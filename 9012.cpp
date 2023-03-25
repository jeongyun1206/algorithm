#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int N;
char str[100];

int main(void)
{

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        stack<int> s;
        fill(str, str + 100, 0);
        cin >> str;
        for (int idx = 0; str[idx]; idx++)
        {
            if (str[idx] == '(')
                s.push(1);
            else if (str[idx] == ')')
            {
                if (!s.empty() && s.top() == 1)
                    s.pop();
                else
                    s.push(0);
            }
        }
        if (!s.empty())
            cout << "NO" << '\n';
        else
            cout << "YES" << '\n';
    }
}