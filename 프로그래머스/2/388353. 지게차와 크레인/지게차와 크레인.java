class Solution {
    public int solution(String[] storageString, String[] requests) {
        char[][] storage = convertStorage(storageString);
        
        for (String req : requests) {
            if (req.length() != 1)
                crain(storage, req);
            else
                lift(storage, req);
        }
        
        // for (int i = 0; i < storage.length; i++) {
        //     for (int j = 0; j < storage[0].length; j++) {
        //         System.out.print(storage[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        
        return countStorage(storage);
    }
    
    private void lift(char[][] storage, String req) {
        int[][] visited = new int[storage.length][storage[0].length];
        dfs(storage, req, 0, 0, visited);
    }
    
    private void dfs(char[][] storage, String req, int x, int y, int[][] visited) {
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        
        if (x < 0 || x >= storage.length || y < 0 || y >= storage[0].length)
            return;
        if (storage[x][y] == req.charAt(0)) {
            storage[x][y] = 0;
            visited[x][y] = 1;
            return;
        }
            
        if (visited[x][y] == 1 || storage[x][y] != 0) return;
        visited[x][y] = 1;
        
        for (int i = 0; i < 4; i++) {
            dfs(storage, req, x + dirX[i], y + dirY[i], visited);
        }
    }
    
    private void crain(char[][] storage, String req) {
        for (int i = 1; i < storage.length - 1; i++) {
            for (int j = 1; j < storage[0].length - 1; j++) {
                if (storage[i][j] == req.charAt(0))
                    storage[i][j] = 0;
            }
        }
    }
    
    private int countStorage(char[][] storage) {
        int cnt = 0;
        for (int i = 1; i < storage.length - 1; i++) {
            for (int j = 1; j < storage[0].length - 1; j++) {
                if (storage[i][j] != 0)
                    cnt++;
            }
        }
        return cnt;
    }
    
    private char[][] convertStorage(String[] storageString) {
        char[][] storage = new char[storageString.length + 2][storageString[0].length() + 2];
        for (int i = 1; i <= storageString.length; i++) {
            for (int j = 1; j <= storageString[0].length(); j++) {
                storage[i][j] = storageString[i - 1].charAt(j - 1);
            }
        }
        return storage;
    }
}