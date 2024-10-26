package javaLamdaBasic;

public class TypeInference {
	public static void main ( String[] args) {
		StringLengthLamda stringLengthLamda = (String s ) -> s.length();{
			System.out.print(stringLengthLamda.StringLength("Hello Lambda"));
		}
		
		
	}
	
	
	public interface StringLengthLamda{
		public abstract int StringLength(String s);
	}

}


