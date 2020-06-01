package adk.role;

import adk.data.DCIData;
import adk.exception.DCIRoleInstanceBuildException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DCIRoleFactoryTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenDataTypeNotMatchedWithRoleDeclared() throws DCIRoleInstanceBuildException {
        exceptionRule.expect(DCIRoleInstanceBuildException.class);
        exceptionRule.expectMessage("No matched constructor found in role class adk.role.DCIRoleFactoryTest$TestRole, the role TestRole declared DCIData type should be adk.role.DCIRoleFactoryTest$Bar");

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