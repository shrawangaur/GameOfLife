package com.ptc.gameoflife;

public class CellCoordinateOutOfBoundariesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CellCoordinateOutOfBoundariesException(String message){
		super(message);
	}

}
