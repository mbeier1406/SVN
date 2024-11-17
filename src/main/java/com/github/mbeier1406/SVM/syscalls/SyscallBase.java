package com.github.mbeier1406.SVM.syscalls;

import com.github.mbeier1406.SVM.MEM;

/**
 * Enthält grundlegende Funktionen und Daten für alle {@linkplain SyscallInterface Syscalls}.
 */
public abstract class SyscallBase implements SyscallInterface<Short> {

	/** Erlaubt den Systemaufrufen den Zugriff auf den Hauptspeicher */
	protected MEM.Instruction<Short> mem;

	/** {@inheritDoc} */
	@Override
	public void setMemory(final MEM.Instruction<Short> mem) {
		this.mem = mem;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object anotherObject) {
		return anotherObject != null && this.getClass().getName().equals(anotherObject.getClass().getName());
	}

}
