package com.ptc.gameoflife;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestGrid {

	@Test
	public void grid_should_be_created_given_active_cells_are_present_in_it() throws Exception {
		ArrayList<Cell> aliveCells = new ArrayList<Cell>();
		Cell c = new Cell(0, 0);
		Cell b = new Cell(2, 1);
		aliveCells.add(c);
		aliveCells.add(b);
		Grid g = new Grid(aliveCells);
		assertFalse(g.isEmpty());
	}

	@Test
	public void grid_must_have_boundaries_specified_while_creating_grid() throws Exception {
		ArrayList<Cell> al = new ArrayList<Cell>();
		Grid g = new Grid(al, 5, 5);
		assertEquals(5, g.getWidth());
		assertEquals(5, g.getHeight());
	}

	@Test
	public void cell_must_throw_outofboundaries_exception_when_goes_outside_specified_grid_boundary() throws Exception {
		try {
			Cell c = new Cell(6, 6);
			ArrayList<Cell> aliveCells = new ArrayList<Cell>();
			aliveCells.add(c);
			Grid g = new Grid(aliveCells, 3, 3);
			fail("Cell coordinates must be inside the boundaries of the grid");
		} catch (CellCoordinateOutOfBoundariesException expected) {
			assertEquals("Cell coordinates are outside the grid boundaries",
					expected.getMessage());
		}
	}

    @Test
	public void new_grid_should_be_empty_if_there_is_no_active_cells_generated_after_tick() throws Exception {
		ArrayList<Cell> aliveCells = new ArrayList<Cell>();
		Grid g = new Grid(aliveCells, 5, 5);
		assertTrue(g.tick().isEmpty());
	}

    @Test
	public void single_cell_should_die_after_tick_in_grid() throws Exception {
		ArrayList<Cell> aliveCells = new ArrayList<Cell>();
		Cell c = new Cell(1, 1);
		aliveCells.add(c);
		Grid g = new Grid(aliveCells, 3, 3);
		assertTrue(g.tick().getAliveCells().size() == 0);
	}

    @Test
	public void four_cells_should_be_generated_after_tick_with_three_active_cells() throws Exception {
		ArrayList<Cell> aliveCells = new ArrayList<Cell>();
		Cell a = new Cell(0, 2);
		Cell b = new Cell(0, 1);
		Cell c = new Cell(1, 2);
		aliveCells.add(c);
		aliveCells.add(b);
		aliveCells.add(a);
		Grid g = new Grid(aliveCells, 3, 3);
		assertTrue(g.tick().getAliveCells().size() == 4);
	}
}
