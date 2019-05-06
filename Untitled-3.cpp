    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size(), start = -1, end = -2;
        int mn = nums[n - 1], mx = nums[0];
        for (int i = 1; i < n; ++i) {
            mx = max(mx, nums[i]);
            mn = min(mn, nums[n - 1 - i]);
            if (mx > nums[i]) end = i;
            if (mn < nums[n - 1 - i]) start = n - 1 - i;
        }
        return end - start + 1;
    }

    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size(), start = -1, end = -2;
        int mn = nums[n - 1], mx = nums[0];
        for (int i = 1; i < n; ++i) {
            mx = max(mx, nums[i]);
            if (mx > nums[i]) end = i;
        }

        for (int i = 1; i < n; ++i) {
            mn = min(mn, nums[n - 1 - i]);
            if (mn < nums[n - 1 - i]) start = n - 1 - i;
        }

        return end - start + 1;
    }

    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();

        int mx = nums[0];
        int start = -1;
        for (int i = 1; i < n; ++i) {
            mx = max(mx, nums[i]);
            if (mx > nums[i]) end = i;
        }

        int mn = nums[n - 1];
        int end = -2;
        for (int i = n-1; i >= 0; --i) {
            mn = min(mn, nums[i]);
            if (mn < nums[i]) start = i;
        }

        return end - start + 1;
    }
