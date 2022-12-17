package br.com.ada.merge;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int n = 5;
		
		int[] vetor = new int[n];
		for (int i = 0; i < n; i++) {
			vetor[i] = (int) (Math.random() * 101);
		}
		
		imprimir(vetor);
		mergeSort(vetor);
		imprimir(vetor);
	}

	private static void mergeSort(int[] vetor) {
		int tam = vetor.length;
		if (tam < 2) {
			return;
		}
		int meio = tam / 2;
		int[] esq = new int[meio];
		int[] dir = new int[tam - meio];
		
		for (int i = 0; i < meio; i++) {
			esq[i] = vetor[i];
		}
		
		for (int i = meio; i < tam; i++) {
			dir[i - meio] = vetor[i];
		}
		
		mergeSort(esq);
		mergeSort(dir);
		merge(esq, dir, vetor);
	}

	private static void merge(int[] esq, int[] dir, int[] original) {
		
		int tamE = esq.length;
		int tamD = dir.length;
		
		int i = 0, j = 0, k = 0;
		while (i < tamE && j < tamD) {
			if (esq[i] < dir[j]) {
				original[k++] = esq[i++];
			} else {
				original[k++] = dir[j++];
			}
		}
		while (i < tamE) {
			original[k++] = esq[i++];
		}
		while (j < tamD) {
			original[k++] = dir[j++];
		}
	}

	public static void imprimir(int[] vetor) {
		System.out.println(Arrays.toString(vetor));
	}
}