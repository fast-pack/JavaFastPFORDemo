package org.example;

import me.lemire.integercompression.FastPFOR128;
import me.lemire.integercompression.IntWrapper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FastPFOR128 fastpfor = new FastPFOR128();

        int N = 9984;
        int[] data = new int[N];
        for (var i = 0; i < N; i += 150) {
            data[i] = i;
        }

        int[] compressedoutput1 = new int[N + 1024];

        IntWrapper inputoffset1 = new IntWrapper(0);
        IntWrapper outputoffset1 = new IntWrapper(0);

        fastpfor.compress(data, inputoffset1, N, compressedoutput1, outputoffset1);
        int compressedsize1 = outputoffset1.get();

        int[] recovered1 = new int[N];
        inputoffset1 = new IntWrapper(0);
        outputoffset1 = new IntWrapper(0);
        fastpfor.uncompress(compressedoutput1, outputoffset1, compressedsize1, recovered1, inputoffset1);

        // quick verification: count mismatches
        int mismatches = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] != recovered1[i]) mismatches++;
        }

        System.out.println("N=" + N + " compressedSizeWords=" + compressedsize1 + " mismatches=" + mismatches);
        System.out.println("first 20 original: " + Arrays.toString(Arrays.copyOf(data, 20)));
        System.out.println("first 20 recovered: " + Arrays.toString(Arrays.copyOf(recovered1, 20)));
    }
}
