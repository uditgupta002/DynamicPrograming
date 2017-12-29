class InterleavingCheck {
	public boolean isInterLeave(String a,String b,String c)
	{
        boolean IL[][] = new boolean[a.length()+1][b.length()+1];
        
        if(c.length() != a.length()+b.length())
            return false;
        
        for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                
                if(i == 0 && j == 0){
                    IL[i][j] = true;
                } else if(i == 0){
                    IL[i][j] = (b.charAt(j-1) == c.charAt(j-1)) ? IL[i][j-1] : false;
                } else if(j == 0){
                    IL[i][j] = (a.charAt(i-1) == c.charAt(i-1)) ? IL[i-1][j] : false;
                } else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1)){
                    IL[i][j] = IL[i-1][j];
                } else if(a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                    IL[i][j] = IL[i][j-1];
                } else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                    IL[i][j] = (IL[i][j-1] || IL[i-1][j]);
                }
            }
        }
        return IL[a.length()][b.length()];
	}
}
