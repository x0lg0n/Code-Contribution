public static void trapping_water(int height[]){
        int n= height.length;
        int right_max[]= new int[n];
        int left_max[]= new int[n];
        left_max[0]=height[0];
        right_max[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        int trappedWater=0;
        for(int i=0;i<n;i++){
            trappedWater +=Math.min(right_max[i],left_max[i])-height[i];
        }
        System.out.print(trappedWater);
    }
