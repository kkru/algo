#include <iostream>
#include <string>
using namespace std;

int n;
bool areFriends[10][10];
int countPairings(bool[]);

int main()
{
    int cases;
    cin >> cases;
    while (cases--)
    {
        int pair;
        int answer;
        bool taken[10];

        cin >> n;
        cin >> pair;

        for (int i = 0; i < n; i++)
        {
            taken[i] = false;
            for (int j = 0; j < n; j++)
            {
                areFriends[i][j] = false;
            }
        }

        for (int i = 0; i < pair; i++)
        {
            int first, second;
            cin >> first;
            cin >> second;
            areFriends[first][second] = true;
            areFriends[second][first] = true;
        }

        answer = countPairings(taken);

        cout << answer << endl;
    }
}

int countPairings(bool taken[10])
{
    int firstFree = -1;
    for (int i = 0; i < n; i++)
    {
        if (!taken[i])
        {
            firstFree = i;
            break;
        }
    }
    if (firstFree == -1)
        return 1;
    int ret = 0;
    for (int pairWith = firstFree + 1; pairWith < n; pairWith++)
    {
        if (!taken[pairWith] && areFriends[firstFree][pairWith])
        {
            // cout << n << "//first : " << firstFree << "//second : " << pairWith << endl;
            taken[firstFree] = taken[pairWith] = true;
            ret += countPairings(taken);
            taken[firstFree] = taken[pairWith] = false;
        }
    }
    return ret;
}