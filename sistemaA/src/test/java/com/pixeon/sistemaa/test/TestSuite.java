package com.pixeon.sistemaa.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pixeon.sistemaa.repository.jpa.ExameRepositoryJPATest;
import com.pixeon.sistemaa.service.rn.ExameServiceRNTest;
import com.pixeon.sistemaa.web.ExameBeanTest;

@RunWith(Suite.class)
@SuiteClasses({ ExameBeanTest.class, ExameServiceRNTest.class, ExameRepositoryJPATest.class })
public class TestSuite {

}
