package com.juaracoding.ujiantest;

import static org.junit.Assert.*;

import java.lang.invoke.MethodHandles;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.junit.rules.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.juaracoding.ujian.Kolam;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class TestKolam {
	
	static final Logger log = getLogger(lookup().lookupClass());
	private static final Double Null = null;
	Kolam kolam;

	@Before
	public void setUp() throws Exception {
		kolam = new Kolam();
	}
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		@Override
		protected void succeeded(Description description) {
			log.debug("Pesan sukses: {}", description.getMethodName());
		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			log.debug("Pesan failed: {}", description.getMethodName());
		}
		
	};


	@Test
	@FileParameters("src/test/resources/kelilingkolam.csv")
	public void testKelilingKolam(double p, double l, double t, double expect) {
		double actual = kolam.kelilingKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	public void testKelilingKolamBukanAngka() {
		String panjangBukanAngka = "A";
		String lebarBukanAngka = "A";
		String tinggiBukanAngka = "A";
		
		double conver1 = Double.parseDouble(panjangBukanAngka);
		double convert2 = Double.parseDouble(lebarBukanAngka);
		double convert3 = Double.parseDouble(tinggiBukanAngka);
		
		double actual = kolam.kelilingKolam(conver1, convert2, convert3);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testKelilingKolamAngkaNegatif() {
		double p = -5;
		double l = -2;
		double t = -9;
		
		double actual = kolam.kelilingKolam(p, l, t);
		
		assertEquals(64, actual, 0.0);
	}
	
	@Test
	public void testKelilingKolamAngkaNull() {
		double p = 0;
		double l = 0;
		double t = 0;
		Double panjangNull = Null;
		Double lebarNull = Null;
		Double tinggiNull = Null;
		
		double actual = kolam.kelilingKolam(p, l, t);
		
		assertNull(panjangNull);
		assertNull(lebarNull);
		assertNull(tinggiNull);
		assertEquals(0, actual, 0.0);
	}
	
	@Test
	@FileParameters("src/test/resources/volumeairkolam.csv")
	public void testVolumeKolam(double p, double l, double t, double expect) {
		double actual = kolam.volumeAirKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamBukannAngka() {
		String panjangVolumeBukanAngka = "A";
		String lebarVolumeBukanAngka = "A";
		String tinggiVolumeBukanAngka = "A";
		
		double conver1 = Double.parseDouble(panjangVolumeBukanAngka);
		double convert2 = Double.parseDouble(lebarVolumeBukanAngka);
		double convert3 = Double.parseDouble(tinggiVolumeBukanAngka);
		
		double actual = kolam.volumeAirKolam(conver1, convert2, convert3);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamAngkaNegatif() {
		double p = -5;
		double l = -2;
		double t = -9;
		
		double actual = kolam.volumeAirKolam(p, l, t);
		
		assertEquals(64, actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamAngkaNull() {
		double p = 0;
		double l = 0;
		double t = 0;
		Double panjangAirNull = Null;
		Double lebarAirNull = Null;
		Double tinggiAirNull = Null;
		
		double actual = kolam.volumeAirKolam(p, l, t);
		
		assertNull(panjangAirNull);
		assertNull(lebarAirNull);
		assertNull(tinggiAirNull);
		assertEquals(0, actual, 0.0);
	}

}
