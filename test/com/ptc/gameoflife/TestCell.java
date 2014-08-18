package com.ptc.gameoflife;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestCell {

    @Test
	public void cell_should_survive_if_it_is_alive_and_have_appropriate_neighbors() throws Exception {
		Cell c = new Cell(0, 0);
		Cell x = new Cell(0, 1);
		Cell y = new Cell(1, 0);
		Cell z = new Cell(4, 4);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(c);
		cells.add(x);
		cells.add(y);
		cells.add(z);
		c.setCellParameters(cells);
		assertTrue(c.willSurvive());

	}

	@Test
	public void single_cell_should_have_zero_neighbors() throws Exception {
		Cell c = new Cell(0, 0);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		c.setCellParameters(cells);
		assertEquals(0, c.getNumberOfNeighbors());
	}

	@Test
	public void cell_should_detect_when_it_has_one_neighbor() throws Exception {
		Cell c = new Cell(2, 2);
		Cell n1 = new Cell(2, 1);
		Cell n2 = new Cell(0, 0);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(n1);
		cells.add(n2);
		c.setCellParameters(cells);
		assertEquals(1, c.getNumberOfNeighbors());
	}

	@Test
	public void cells_with_same_coordinates_should_be_equal() throws Exception {
		Cell c = new Cell(2, 2);
		Cell c1 = new Cell(2, 2);
		assertTrue(c.equals(c1));
	}

	@Test
	public void cell_must_revive_if_surrounded_by_three_alive_cell() throws Exception {
		Cell c = new Cell(2, 2);
		Cell n1 = new Cell(2, 1);
		Cell n2 = new Cell(1, 2);
		Cell n3 = new Cell(1, 1);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(n1);
		cells.add(n2);
		cells.add(n3);
		c.setCellParameters(cells);
		assertTrue(c.willRevive());
	}

	@Test
	public void cell_coordinate_should_get_created_when_cell_is_created_with_defined_coordinates() throws Exception {
		Cell c = new Cell(4, 1);
		assertEquals(c.getxCoordinate(), 4);
		assertEquals(c.getyCoordinate(), 1);
	}

	@Test
	public void should_throw_exception_if_any_cell_boundary_is_negative()
			throws Exception {
		try {
			Cell c = new Cell(1, -1);
			fail("Can't have negative value");
		} catch (NegativeCoordinateException ex) {
			assertEquals("Coordinates must have positive values",
					ex.getMessage());
		}
	}

	@Test
	public void should_throw_exception_if_cell_boundary_is_negative() throws Exception {
		try {
			Cell c = new Cell(-1, 0);
			fail("Can't have a negative coordinate");
		} catch (NegativeCoordinateException expected) {
			assertEquals("Coordinates must have positive values",
					expected.getMessage());
		}
	}
}
