package doItAlgolithm._7장;

public class Chapter07_Q04 {
	private int max; 
	private int num; 
	private int[] set; 

	public Chapter07_Q04(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; 
		} catch (OutOfMemoryError e) { 
			max = 0;
		}
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public int indexOf(int n) {
		for (int i = 0; i < num; i++)
			if (set[i] == n)
				return i;
		return -1;
	}

	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}

	public boolean add(int n) {
		if (num >= max || contains(n) == true) 
			return false;
		else {
			set[num++] = n; 
			return true;
		}
	}

	public boolean remove(int n) {
		int idx;

		if (num <= 0 || (idx = indexOf(n)) == -1) 
			return false;
		else {
			set[idx] = set[--num]; 
			return true;
		}
	}

	public void copyTo(Chapter07_Q04 s) {
		int n = (s.max < num) ? s.max : num;
		for (int i = 0; i < n; i++)
			s.set[i] = set[i];
		s.num = n;
	}

	public void copyFrom(Chapter07_Q04 s) {
		int n = (max < s.num) ? max : s.num; 
		for (int i = 0; i < n; i++)
			set[i] = s.set[i];
		num = n;
	}

	public boolean equalTo(Chapter07_Q04 s) {
		if (num != s.num) 
			return false;

		for (int i = 0; i < num; i++) {
			int j = 0;
			for (; j < s.num; j++)
				if (set[i] == s.set[j])
					break;
			if (j == s.num)
				return false;
		}
		return true;
	}

	public void unionOf(Chapter07_Q04 s1, Chapter07_Q04 s2) {
		copyFrom(s1);
		for (int i = 0; i < s2.num; i++) 
			add(s2.set[i]);
	}

	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}

	public void clear() {
	   num = 0;
	}
	
	public void intersectionOf(Chapter07_Q04 s1, Chapter07_Q04 s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (s2.contains(s1.set[i]))
				add(s1.set[i]);
	}

	public void differenceOf(Chapter07_Q04 s1, Chapter07_Q04 s2) {
		clear();
		for (int i = 0; i < s1.num; i++)
			if (!s2.contains(s1.set[i]))
				add(s1.set[i]);
	}
}
