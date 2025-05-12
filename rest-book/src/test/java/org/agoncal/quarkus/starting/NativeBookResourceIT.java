package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class NativeBookResourceIT extends BookResourceTest {
    // Execute the same tests but in native mode.
    // The @QuarkusTest annotation is inherited from BookResourceTest
    // and the @NativeImageTest annotation is used to run the tests in native mode.
    // The tests will be executed in a native image environment.

}
