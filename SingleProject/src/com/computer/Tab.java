package com.computer;

public class Tab extends Computer implements Graphic {
	public Tab() {
		
	}
	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}
	@Override
	public void operate(int time) {
		int cur_battery = super.getBatterty() - (time / 5 );
		System.out.print(cur_battery);
	}
	@Override
	public double rendering(int size) {
		double timing = (double)size / (super.getCpu() * super.getMemory()) * 30;
		return timing;
	}
}
