#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::string lcs1, lcs2;
    std::getline(std::cin, lcs1);
    std::getline(std::cin, lcs2);

    std::vector<int> dp(lcs2.length(), 0);

    for (size_t i = 0; i < lcs1.length(); ++i) {
        int cnt = 0;
        for (size_t j = 0; j < lcs2.length(); ++j) {
            if (cnt < dp[j]) {
                cnt = dp[j];
            } else if (lcs1[i] == lcs2[j]) {
                dp[j] = cnt + 1;
            }
        }
    }

    std::cout << *std::max_element(dp.begin(), dp.end()) << std::endl;

    return 0;
}
