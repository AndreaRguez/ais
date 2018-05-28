package es.codeurjc.ais.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test1 {
	
	Board tab;
		
	@BeforeEach
	public void setUp() {
		tab = new Board();
		tab.enableAll();		
	}
	
	@Test
	public void winP1() {
		tab.getCell(0).value = "X";
		tab.getCell(2).value = "O";
		tab.getCell(4).value = "X";
		tab.getCell(5).value = "O";
		tab.getCell(8).value = "X";
		int[] w = {0,4,8};
		int[] o = tab.getCellsIfWinner("O");
		int[] x = tab.getCellsIfWinner("X");
		assertEquals(o, null);
		for (int i =0;i<3;i++) {
			assertEquals(w[i],x[i]);
		}
	}
	
	@Test
	public void winP2() {
		tab.getCell(4).value = "X";
		tab.getCell(0).value = "O";
		tab.getCell(6).value = "X";
		tab.getCell(2).value = "O";
		tab.getCell(7).value = "X";
		tab.getCell(1).value = "O";
		int[] w = {0,1,2};
		int[] x = tab.getCellsIfWinner("X"); 
		int[] o = tab.getCellsIfWinner("O");
		assertEquals(x, null);
		for (int i =0;i<3;i++) {
			assertEquals(w[i],o[i]);
		}
		
	}
	
	@Test
	public void draw() {
		boolean f = tab.checkDraw();
		assertEquals(f,false);
		tab.getCell(4).value = "X";
		tab.getCell(0).value = "O";
		tab.getCell(6).value = "X";
		tab.getCell(2).value = "O";
		tab.getCell(1).value = "X";
		tab.getCell(7).value = "O";
		tab.getCell(3).value = "X";
		tab.getCell(5).value = "O";
		tab.getCell(8).value = "X";

		boolean t = tab.checkDraw();
		assertEquals(t,true);
	}
	

}

