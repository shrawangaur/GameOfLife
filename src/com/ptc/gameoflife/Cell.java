package com.ptc.gameoflife;

import java.util.ArrayList;
import java.util.Iterator;

public class Cell {
	private int xCoordinate;
	private int yCoordinate;
	private int numberOfNeighbors;
	private boolean isAlive;

	public Cell() throws NegativeCoordinateException {
	}

	public Cell(int _xAxisCoordinate, int _yAxisCoordinate) throws NegativeCoordinateException {

		this.setXCoordinate(_xAxisCoordinate);
		this.setYCoordinate(_yAxisCoordinate);

	}

	private void checkIsAlive(ArrayList<Cell> cells) {
		if (cells.contains(this)) {
			this.setAlive(true);
		} else {
			setAlive(false);
		}
	}

	private void countNeighbors(ArrayList<Cell> cells) {
		int counter = GameLiterals.ZERO;
		Iterator<Cell> it = cells.iterator();

		while (it.hasNext()) {
			if (this.isNeighbor(it.next())) {
				counter++;
			}
		}
		this.setNumberOfNeighbors(counter);
	}

	@Override
	public final boolean equals(Object o) {
		return this.getxCoordinate() == ((Cell) o).getxCoordinate()
				&& this.getyCoordinate() == ((Cell) o).getyCoordinate();
	}

	public final int getNumberOfNeighbors() {
		return numberOfNeighbors;
	}

	public final int getxCoordinate() {
		return this.xCoordinate;
	}

	public final int getyCoordinate() {
		return this.yCoordinate;
	}

	private boolean isNeighbor(Cell cell) {

		return Math.abs(this.getxCoordinate() - cell.getxCoordinate()) <= GameLiterals.ONE
				&& Math.abs(this.getyCoordinate() - cell.getyCoordinate()) <= GameLiterals.ONE && !this.equals(cell);
	}

	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public final void setCellParameters(ArrayList<Cell> cells) {
		this.countNeighbors(cells);
		this.checkIsAlive(cells);
	}

	private void setNumberOfNeighbors(int numberOfNeighbors) {
		this.numberOfNeighbors = numberOfNeighbors;
	}

	private void setXCoordinate(int index_X) throws NegativeCoordinateException {
		if (index_X < GameLiterals.ZERO) {
			throw new NegativeCoordinateException(
					"Coordinates must have positive values");
		}
		this.xCoordinate = index_X;
	}

	private void setYCoordinate(int index_Y) throws NegativeCoordinateException {
		if (index_Y < GameLiterals.ZERO) {
			throw new NegativeCoordinateException(
					"Coordinates must have positive values");
		}
		this.yCoordinate = index_Y;

	}

	public final boolean willRevive() {
		if (!(this.isAlive)) {
			if (numberOfNeighbors == GameLiterals.THREE) {
				return true;
			}
		}
		return false;
	}

	public final boolean willSurvive() {
		return (this.isAlive && (getNumberOfNeighbors() == GameLiterals.TWO || getNumberOfNeighbors() == GameLiterals.THREE));
	}

}
