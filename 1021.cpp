#include <iostream>
#include <algorithm>
#include <deque>


using namespace std;

int N, M;
int arr[50];
int ans;

int find_deque_idx(deque<int> dq, int arr_ele)
{
    for (int i = 0; i < dq.size(); i++)
    {
        if (dq[i] == arr_ele)
            return (i);
    }
    return (-1);
}

int main(void)
{
    cin >> N >> M;
    deque<int> dq;
    for (int i = 1; i <= N; i++)
        dq.push_back(i);
    for (int i = 0; i < M; i++)
        cin >> arr[i];
    for (int i = 0; i < M; i++)
    {
        int d_idx = find_deque_idx(dq, arr[i]);
        if (d_idx < dq.size() - d_idx)
        {
            for (int j = 0; j < d_idx; j++)
            {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else
        {
            for (int j = 0; j < dq.size() - d_idx; j++)
            {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
        ans += min(d_idx, (int)dq.size() - d_idx);
        dq.pop_front();
    }
    cout << ans;
}