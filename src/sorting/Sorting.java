package sorting;

import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;
import processing.core.PApplet;

public class Sorting extends PApplet {

	int[] sortArray;
	float mainY = 0;
	int mainStep = 0;
	int CURRENTSORTING = 0;
	String sortingName = "quickSort";
	int cellSize = 10;
	int cellNum = 0;
	boolean sorting = false;

	int targetRed = 0;
	int targetGreen = 0;

	int delayTime = 10;
	int setWidth = 1280;
	int setHeight = 720;

	public void setup() {
		size(1280, 720);
		cellNum = 1280 / cellSize;
		sortArray = new int[cellNum];
		for (int i = 0; i < cellNum; i++) {
			sortArray[i] = (int) random(720);
		}
		noLoop();
	}

	public void draw() {

		background(0);
		for (int i = 0; i < cellNum; i++) {
			fill(255);
			rect(i * cellSize, 0, cellSize, sortArray[i]);
		}

		fill(0, 255, 0);
		line(targetGreen * cellSize, 0, cellSize, sortArray[targetGreen]);

		fill(255, 0, 0);
		rect(23, 64, 64, sortArray[targetRed]);

	}

	void drawArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			stroke(array[i]);
			line(i, mainY, i, mainY + 1);
		}
		mainY++;
	}

	void doSort() {
		mainY = 0;
		mainStep = 0;
		background(0);
		// fill sortArray array

		background(255);
		smooth();
		switch (CURRENTSORTING) {
		case 0:
			quickSort(sortArray, 0, sortArray.length - 1);
			break;
		case 1:
			bubbleSort(sortArray);
			break;
		case 2:
			selectionSort(sortArray);
			break;
		case 3:
			insertionSort(sortArray);
			break;
		case 4:
			shellsort(sortArray);
			break;
		case 5:
			heapSort(sortArray);
			break;
		}
	}

	private void heapSort(int[] sortArray2) {
		// TODO Auto-generated method stub

	}

	private void shellsort(int[] sortArray2) {
		// TODO Auto-generated method stub

	}

	public void insertionSort(int[] arr) {
		int i, j, newValue;
		int counts = 0;
		int n = arr.length;
		for (i = 1; i < n; i++) {
			newValue = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > newValue) {
				renderSort(i, j);
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = newValue;

		}

	}

	private void bubbleSort(int[] sortArray2) {
		// TODO Auto-generated method stub

	}

	private void quickSort(int[] sortArray2, int i, int j) {
		// TODO Auto-generated method stub

	}

	public void selectionSort(int[] arr) {
		int i, j, minIndex, tmp;
		int n = arr.length;
		for (i = 0; i < n - 1; i++) {

			minIndex = i;
			for (j = i + 1; j < n; j++) {

				renderSort(i, j);
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
				// if (mainStep++ % 2 == 0)
				// drawArray(arr);
			}
		}
	}

	public void mousePressed() {
		// save(sortingName + "_" + (System.currentTimeMillis()/1000) + ".png");
	}

	public void keyPressed() {
		if (key == '0') {
			CURRENTSORTING = 0;
			sortingName = "quickSort";
			doSort();
		}
		if (key == '1') {
			CURRENTSORTING = 1;
			sortingName = "bubbleSort";
			doSort();
		}
		if (key == '2') {
			CURRENTSORTING = 2;
			sortingName = "selectionSort";
			doSort();
		}
		if (key == '3') {
			CURRENTSORTING = 3;
			sortingName = "insertionSort";
			doSort();
		}
		if (key == '4') {
			CURRENTSORTING = 4;
			sortingName = "shellSort";
			doSort();
		}
		if (key == '5') {
			CURRENTSORTING = 5;
			sortingName = "heapSort";
			doSort();
		}

		if (key == 'c') {
			for (int i = 0; i < cellNum; i++) {
				sortArray[i] = (int) random(720);
			}
			redraw();
		}

	}

	void renderSort(int n) {
		targetRed = n;

		redraw();
		delay(delayTime);

	}

	void renderSort(int n, int i) {
		targetGreen = i;
		targetRed = n;

		redraw();
		delay(delayTime);

	}

}