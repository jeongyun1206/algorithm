#include <string>
#include <vector>
#include <map>

using namespace std;
vector<string> solution(vector<string> players, vector<string> callings) {
    map<int, string> playerName;
    map<string, int> playerRank;
    
    for (int i = 0; i < players.size(); i++) {
        playerName[i] = players[i];
        playerRank[players[i]] = i;
    }
    
    for (string calling : callings) {
        int rank = playerRank[calling];
        string aheadPlayer = playerName[rank - 1];
        // 등수 변화
        playerRank[calling]--;
        playerRank[aheadPlayer]++;
        playerName[rank] = aheadPlayer;
        playerName[rank - 1] = calling;
    }
    
    vector<string> answer;
    for (int i = 0; i < players.size(); i++)
        answer.push_back(playerName[i]);
    return answer;
}