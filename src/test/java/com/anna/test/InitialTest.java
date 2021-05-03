package com.anna.test;

import com.anna.base.Base;
import com.anna.base.FrontPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public  class InitialTest extends Base {
    private FrontPage frontPage;

    @BeforeAll
    public void startUp(){
        startBrowser();
        frontPage = new FrontPage(driver);
    }

    @AfterAll
    public void tearDown(){
        close();
    }

    /**
     *
     * This test verifies
     * 1. Two people were added in the list
     * 2. Clear the selection
     */
    @Test
    public void verifyContactIconOnToolBar(){
        frontPage = new FrontPage(driver);

        //clear the selection to make sure nothing else left from previous actions
        frontPage.clearSelection();

        //open the drop down
        frontPage.openDropDown();

        //add two people with the names
        String personNameOne = frontPage.addPerson(1);
        String personNameTwo = frontPage.addPerson(2);

        //close the drop down
        frontPage.closeDropDown();

        //Verify that the two people were selected
        assertTrue(frontPage.verifyAddedPerson(personNameOne), "Verify that the first person was added");
        assertTrue(frontPage.verifyAddedPerson(personNameTwo), "Verify that the second person was added");

        //clear the selection
        frontPage.clearSelection();
    }
}

