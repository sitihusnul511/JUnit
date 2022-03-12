package com.juaracoding.ujian.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.juaracoding.ujiantest.*;

@RunWith(Suite.class)
@SuiteClasses({
	TestKolam.class,
	TestSuhu.class
})

public class KolamSuhuTest {

}
