package com.spring.sh4.spring04;

public interface Box {
	void init();
	void destroy();
	int getLength();
	void setLength(int length);
	int getBreadth();
	void setBreadth(int breadth);
	int getHeight();
	void setHeight(int height);
	int calcVolume();
	void setLogger(Logger logger);
	Logger getLogger();
}

