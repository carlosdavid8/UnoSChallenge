package us.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import us.model.MineSeeker;

class MineSeekerTest {
	MineSeeker ms= new MineSeeker();


	@Test
	void calculateWrongFormat() {
		
		assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
            	ArrayList<Integer> list = new ArrayList<Integer>();// Creating arraylist
        		list.add(1);// Adding object in arraylist
        		list.add(2);
        		list.add(3);
        		list.add(4);
        		ms.calculateMaximumExplosion(list);
        		
            }
        });
		
	}
	
	@Test
	void CalculateSuccesfully() throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();// Creating arraylist
		list.add(2);// Adding object in arraylist
		list.add(9);
		list.add(9);
		list.add(1);
		list.add(1);
		list.add(10);
		list.add(2);
		list.add(11);
		list.add(1);
		list.add(-2);
		list.add(-11);
		list.add(1);
		assertEquals("OK", 3, ms.calculateMaximumExplosion(list));
	}
	

}
