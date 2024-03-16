package org.example;

public class PlaneLayout {
    private char[][] layout;

    public PlaneLayout(int rows, int columns) {
        layout = new char[rows][columns];

        // Initialize all seats as available
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                layout[i][j] = 'O'; // 'O' represents available seat
            }
        }
    }

    public boolean bookSeat(String seatNumber) {
        // Convert seatNumber to row and column index, "row-column"
        String[] parts = seatNumber.split("-");
        if (parts.length != 2) {
            System.out.println("Invalid seat number format.");
            return false;
        }

        try {
            int row = Integer.parseInt(parts[0]) - 1; // Convert to zero-based index
            int column = Integer.parseInt(parts[1]) - 1; // Convert to zero-based index

            // Check if the seat is valid and available
            if (row >= 0 && row < layout.length && column >= 0 && column < layout[0].length && layout[row][column] == 'O') {
                layout[row][column] = 'B'; // 'B' represents booked seat
                return true;
            } else {
                // Seat is already booked
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid seat number format.");
            return false;
        }
    }

    public String displayAvailableSeats() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                if (layout[i][j] == 'O') {
                    // To convert the zero-based row and column indices to one-based indices
                    // as seat numbers are numbered staring from 1.
                    sb.append((i + 1)).append("-").append((j + 1)).append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

    public String displayPlaneLayout() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                // Append seat status
                sb.append(layout[i][j]).append(" ");
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    public int getRows() {
        return layout.length;
    }

    public int getColumns() {
        return layout[0].length;
    }

    public char getSeatStatus(int row, int column) {
        if (row >= 0 && row < layout.length && column >= 0 && column < layout[0].length) {
            return layout[row][column];
        } else {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
    }

    public char[][] getLayout() {
        return layout;
    }

}
