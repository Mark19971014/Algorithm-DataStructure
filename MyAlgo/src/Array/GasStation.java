package Array;

public class GasStation {
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

public static void main(String[] args) {
        GasStation test = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        //test.circularArray(gas);
        System.out.println(test.canCompleteCircuit(gas,cost));
    }
}

