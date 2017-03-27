package com.codebind;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ChefsListTest extends TestCase {
    private final ChefsList ChefTest = new ChefsList("Ham","No Cheese",3,"Hana");

    public void testGetOrder() throws Exception {
        assertEquals(ChefTest.getOrder(), "Ham");
    }

    public void testGetNotes() throws Exception {
        assertEquals(ChefTest.getNotes(), "No Cheese");

    }

    public void testGetTableNo() throws Exception {
        assertEquals(ChefTest.getTableNo(),3);
    }

    public void testGetServer() throws Exception {
        assertEquals(ChefTest.getServer(),"Hana");
    }
}