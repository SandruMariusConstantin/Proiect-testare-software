package pachet1;

import java.io.InvalidClassException;
import java.util.Arrays;
import java.util.Comparator;


/* Definesc clasa Interval ca o pereche numere */
class Interval {
    int x, y;

    public Interval(int x, int y){
        this.x = x;
        this.y = y;
    }
}

/* Definesc clasa SortareIntervale pentru sortarea unui array de perechi dupa primul element */
class SortareIntervale {
    static void sorteaza(Interval a[]) {
        Arrays.sort(a, new Comparator<>() {
            @Override public int compare(Interval p1, Interval p2)
            {
                return p1.x - p2.x;
            }
        });
    }
	
	static int max(int a, int b) {
		if(a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	static int min(int a, int b) {
		if(a <= b) {
			return a;
		} else {
			return b;
		}
	}
}

/*! --------------------------------------------------------------------------
 * Definesc clasa principala MyClass 
 * @param N - numarul de intervale in care Mihaela poate venii la facultate
 * @param M - numarul de intervale in care Decanul este la birou 
 * @param K - numarul de minute de care are nevoie pentru a explica lucrarea
 * @param Mihaela - multimea de intervale in care Mihaela poate venii
 * @param Decanul - multimea de intervale in care Decanul e la birou 
 * ------------------------------------------------------------------------ */ 
class Licenta {
	public int N, M, K;
	
    public Interval[] Mihaela;
    public Interval[] Decanul;
	
	// restrictii - voi alege niste restrictii cu care imi va fi mai usor sa lucrez
	static final int MAX = 20;
    static final int MAX2 = 4;
	static final int MIN = 1;
    static final int MIN2 = 0;

	// Metoda care se ocupa de citirea si verificarea datelor
    public void Citire(String[] arg) {
        int pos = 0;

        this.K = Integer.parseInt(arg[pos]);
        pos++;

        if (this.K < MIN || this.K >= MAX) {
            throw new IllegalArgumentException("K is out of bounds");
        }

        this.N = Integer.parseInt(arg[pos]);
        pos++;

        if (this.N < MIN || this.N > MAX2) {
            throw new IllegalArgumentException("N is out of bounds");
        }

        this.Mihaela = new Interval[N];

        for (int i = 0; i < N; i++) {
            this.Mihaela[i] = new Interval(Integer.parseInt(arg[pos]), Integer.parseInt(arg[pos+1]));

            if (this.Mihaela[i].x < MIN2 || this.Mihaela[i].x >= MAX)
                throw new IllegalArgumentException("Mihaela - x is out of bounds");
				
            if (this.Mihaela[i].y < MIN2 || this.Mihaela[i].y >= MAX)
                throw new IllegalArgumentException("Mihaela - y is out of bounds");
				
            if (this.Mihaela[i].x >= this.Mihaela[i].y) {
                throw new IllegalArgumentException("Mihaela - x should be less than y");
			}

            pos+=2;
        }

        this.M = Integer.parseInt(arg[pos]);
        pos++;

        if (this.M < MIN || this.M > MAX2) {
            throw new IllegalArgumentException("M is out of bounds");
        }

        this.Decanul = new Interval[M];
		
        for (int i = 0; i < M; i++) {
            this.Decanul[i] = new Interval(Integer.parseInt(arg[pos]), Integer.parseInt(arg[pos+1]));

            if (this.Decanul[i].x < MIN2 || this.Decanul[i].x >= MAX)
                throw new IllegalArgumentException("Decanul - x is out of bounds");
			
			if (this.Decanul[i].y < MIN2 || this.Decanul[i].y >= MAX)
                throw new IllegalArgumentException("Decanul - y is out of bounds");
			
            if (this.Decanul[i].x >= this.Decanul[i].y) {
                throw new IllegalArgumentException("Decanul - x should be less than y");

			}

            pos+=2;
        }
    }

	// metoda se va ocupa de gasirea intervalului, iar in cazul in 
	// care nu gaseste, va returna un interval (-1, -1)
    public Interval GasireInterval() {
        SortareIntervale.sorteaza(this.Mihaela);
        SortareIntervale.sorteaza(this.Decanul);
		
        int L = 0, R = 0;
		
        while (L < this.N && R < this.M) {
            int xmax = SortareIntervale.max(this.Mihaela[L].x, this.Decanul[R].x);
            int ymin = SortareIntervale.min(this.Mihaela[L].y, this.Decanul[R].y);

            if (ymin - xmax >= this.K) {
                return (new Interval(xmax, xmax + this.K));
            }

            if (this.Mihaela[L].y < this.Decanul[R].y) {
                L++;
			} else if (this.Mihaela[L].y > this.Decanul[R].y) {
                R++;
			} else {
                L++;
                R++;
            }
        }
		
        return (new Interval(-1, -1));
    }
}

public class MyClass {
    public static void main(String[] arg) {
        Licenta licenta = new Licenta();

        licenta.Citire(arg);

        Interval iesire = licenta.GasireInterval();

        if(iesire.x == -1) {
            System.out.println("Nu exista solutie");
        } else {
            System.out.println("Interval: " + iesire.x + " " + iesire.y);
        }
    }
}