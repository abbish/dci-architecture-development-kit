package com.domainmodeling.dci.adk.core.role;

import com.domainmodeling.dci.adk.core.data.DCIData;
import com.domainmodeling.dci.adk.core.exception.DCIRoleInstanceBuildException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DCIRoleFactoryTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenDataTypeNotMatchedWithRoleDeclared() throws DCIRoleInstanceBuildException {
        exceptionRule.expect(DCIRoleInstanceBuildException.class);
        exceptionRule.expectMessage("No matched constructor found in role class TestRole, the role TestRole declared DCIData type should be Bar");

        DCIRoleFactory.build(TestRole.class, new Bar());
    }

    class TestRole extends AbstractDCIRole<Foo> {

        protected TestRole(Foo data) {
            super(data);
        }

        public String hello() {
            return "hello";
        }
    }

    class Foo implements DCIData {
    }

    class Bar extends Foo implements DCIData {
    }
}