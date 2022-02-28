class BinarySearch {
    private String[] keys = {"dare","incongruous","photocopy","returns","sour","surround"};
    private int beg = 0;
    private int end = keys.length;
    private int mid = end/2;
    public boolean binarySearch(String k, String s, String f) {
       // mid = (f+s)/2;
        if(s.compareTo(f)) {
            return false;
        }//closes if
        else if(k == keys[mid]) {
            return true;
        }//closes else if
        else if(k < keys[mid]) {
            return binarySearch(k,s,mid-1);
        }//closes else if
        else {
            return binarySearch(k,mid+1,f);
        }//closes else
    }//closes binarySearch method
}//closes BinarySearch class


