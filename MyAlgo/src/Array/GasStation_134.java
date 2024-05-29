package Array;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // Total gas in the tank
        int currentGas = 0; // Gas in the tank at the current station
        int startStation = 0; // Starting station index

        for (int i = 0; i < gas.length; i++) {

            //  circular manner, if we go through the array more than one time i < n * arr.length, we still able to access the index by using arr[i % arr.length]
            int index = i % gas.length; // Wrap around the indices

            currentGas += gas[i] - cost[i]; // Calculate the net gas at each station
            // the totol cost in the whole journey ,it might be possible to moving from station C to D(curGas > 0) but not able to move from D-> A-> B ->C
            //we do not update the curGas as long as we can move to the next station, in other words we do not need to restart from the next station
            // However , we need to keep tracking the totalGas cost to see if we have enough gas in the whole journey
            totalGas += gas[i] - cost[i]; // Update the total gas

            // If the current gas is negative, we can't reach the next station
            if (currentGas < 0) {
                currentGas = 0; // Reset the gas in the tank
                startStation = index + 1; // Start from the next station
            }
        }

        // Check if it's possible to complete the circuit
        if (totalGas < 0) {
            return -1; // Not enough total gas to complete the circuit
        } else {
            return startStation % gas.length; // Return the starting station index
        }
    }


    public void circularArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i % arr.length]);
        }
    }

    public int solution(int[] gas, int[] cost){
        int index = 0;
        int total = 0;
        int cur = 0;

        for(int i = 0 ; i <  gas.length; i++){
            total += gas[i] - cost[i];
            cur += gas[i]  - cost[i];
            // if we can not move to the next station from current station; check the next station
            if (cur < 0){
                index = i + 1;
                cur = 0;
            }
        }

        return total >= 0 ? index : -1;
    }

    public int canCompleteCircuit_circuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean canComplete = true;

            // Try to travel the circuit starting from 'start'
            for (int i = 0; i < n; i++) {
                int currentStation = (start + i) % n;
                tank += gas[currentStation] - cost[currentStation];

                // If tank goes negative, we can't complete the circuit from 'start'
                if (tank < 0) {
                    canComplete = false;
                    break;
                }
            }

            // If we can complete the circuit from 'start', return 'start'
            if (canComplete) {
                return start;
            }
        }

        // If no starting point can complete the circuit, return -1
        return -1;
    }
public static void main(String[] args) {
        GasStation_134 test = new GasStation_134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        test.solution(gas,cost);
        //test.circularArray(gas);
        System.out.println(test.canCompleteCircuit(gas,cost));
    }
}

