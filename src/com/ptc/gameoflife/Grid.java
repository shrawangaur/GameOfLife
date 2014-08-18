package com.ptc.gameoflife;

import java.util.ArrayList;
import java.util.Iterator;

public class Grid {

	public static void main(String[] args) throws java.io.IOException {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		try {
			Cell cellA = new Cell(GameLiterals.ZERO, GameLiterals.ZERO);
			Cell cellB = new Cell(GameLiterals.ONE, GameLiterals.ONE);
			Cell cellC = new Cell(GameLiterals.ZERO, GameLiterals.TWO);
			Cell cellD = new Cell(GameLiterals.TWO, GameLiterals.ZERO);
			Cell cellE = new Cell(GameLiterals.TWO, GameLiterals.TWO);
            Cell cellF = new Cell(GameLiterals.TWO, GameLiterals.THREE);
			cellList.add(cellA);
			cellList.add(cellB);
			cellList.add(cellC);
			cellList.add(cellD);
			cellList.add(cellE);
            cellList.add(cellF);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		Grid grid = new Grid(cellList, GameLiterals.FOUR, GameLiterals.FOUR);
		String printString = "";
		try {
			printString = grid.printGrid();
			System.out.print(printString);
            System.out.println("Now After Tick");
            Grid newGrid = grid.tick();
			System.out.print(newGrid.printGrid());
            System.out.println("Now After Tick");
            System.out.println(newGrid.tick().printGrid());
		} catch (NegativeCoordinateException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Cell> aliveCells;
	private int width;

	private int height;

	public Grid(ArrayList<Cell> aliveCells) {
		this.aliveCells = new ArrayList<Cell>();
		this.aliveCells = aliveCells;
	}

	public Grid(ArrayList<Cell> cellList, int width, int height) {
		this.setHeight(height);
		this.setWidth(width);
		this.aliveCells = new ArrayList<Cell>();
		if (checkCellsAreValid(cellList)) {
			this.aliveCells = cellList;
		}
	}

	private boolean checkCellsAreValid(ArrayList<Cell> cellList) {
		boolean validCell = false;
		Iterator<Cell> cellIterator = cellList.iterator();
		while (cellIterator.hasNext()) {
			if (!(isCellInsideBoundaries(cellIterator.next()))) {
				validCell = false;
			} else {
				validCell = true;
			}
		}
		return validCell;
	}

	public ArrayList<Cell> getAliveCells() {
		return aliveCells;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	private boolean isCellInsideBoundaries(Cell cell)
			throws CellCoordinateOutOfBoundariesException {
		if (cell.getxCoordinate() <= this.getWidth() && cell.getyCoordinate() <= this.getHeight()) {
			return true;
		} else {
			throw new CellCoordinateOutOfBoundariesException(
					"Cell coordinates are outside the grid boundaries");
		}
	}

	public boolean isEmpty() {
		return !(this.aliveCells.size() > GameLiterals.ZERO);
	}

	public String printGrid() throws NegativeCoordinateException {
		String printString = "";
		for (int iIndex = GameLiterals.ZERO; iIndex < this.getHeight(); iIndex++) {
			for (int jIndex = GameLiterals.ZERO; jIndex < this.getWidth(); jIndex++) {
				if (this.getAliveCells().contains(new Cell(jIndex, iIndex))) {
					printString += "*";
				} else
					printString += "-";
			}
			printString += "\n";
		}
		return printString;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Grid tick() throws NegativeCoordinateException {
		ArrayList<Cell> newGeneratedCells = new ArrayList<Cell>();
		for (int iIndex = GameLiterals.ZERO; iIndex < this.getWidth(); iIndex++) {
			for (int jIndex = GameLiterals.ZERO; jIndex < this.getHeight(); jIndex++) {
				Cell cell = new Cell(iIndex, jIndex);
				cell.setCellParameters(this.getAliveCells());
				if (cell.willRevive() || cell.willSurvive()) {
					newGeneratedCells.add(cell);
				}
			}
		}
		Grid nextGenerationGrid = new Grid(newGeneratedCells, this.getWidth(), this.getHeight());
		return nextGenerationGrid;
	}
}
