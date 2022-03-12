package com.juaracoding.ujiantest;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;

import com.juaracoding.ujian.Suhu;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class TestSuhu {
	
	static final Logger log = getLogger(lookup().lookupClass());
	private static final Double Null = null;
	
	Suhu suhu;

	@Before
	public void setUp() throws Exception {
		suhu = new Suhu();
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
	@FileParameters("src/test/resources/FkeC.csv")
	public void testKonversiSuhu(double f, double expect) {
		double actual = suhu.KonversiSuhu(f);
		assertEquals(expect, actual, 0.9);
	}
	
	@Test
	public void testKonversiSuhuBukanAngka() {
		String fBukanAngka = "A";
		
		double convert = Double.parseDouble(fBukanAngka);
		
		double actual = suhu.KonversiSuhu(convert);
		String expect = "A";
		assertEquals(Double.parseDouble(expect), actual, 0.0);
	}
	
	@Test
	public void testKonversiSuhuNegatif() {
		double f = -20;
		
		double actual = suhu.KonversiSuhu(f);
		
		assertEquals(28.88, actual, 0.4);
	}
	
	@Test
	public void testKonversiSuhuNull() {
		double f = 0;
		Double fNull = Null;
		
		double actual = suhu.KonversiSuhu(f);
		
		assertNull(fNull);
		assertEquals(0, actual, 0.0);
	}

}
