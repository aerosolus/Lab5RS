package utility;

/**
 * @since 1.2
 */
public class ValuesValidator {

    public static boolean validateWorkerId(String workerID) {
        try {
            Long x = Long.parseLong(workerID);
            if (x > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    public static boolean validateWorkerName(String workerName)
    {
        return (workerName != null && !workerName.isEmpty());
    }

    public static boolean validateWorkerCoordinateX(String stringX)
    {
        try {
            Long x = Long.parseLong(stringX);
            if (x > -975) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    public static boolean validateWorkerCoordinateY(String stringY) {
        try {
            long y = Long.parseLong(stringY);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    public static boolean validateWorkerSalary(String workerSalary) {
        try {
            long salary = Long.parseLong(workerSalary);
            if (salary > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    public static boolean validateWorkerPosition(String workerPosition) {
        return workerPosition.equals("ENGINEER") ||
                workerPosition.equals("HEAD_OF_DEPARTMENT") ||
                workerPosition.equals("DEVELOPER");
    }

    public static boolean validateWorkerStatus(String workerStatus) {
        return workerStatus.equals("FIRED") ||
                workerStatus.equals("HIRED") ||
                workerStatus.equals("REGULAR") ||
                workerStatus.equals("PROBATION");
    }

    public static boolean validateWorkerPersonHeight(String workerHeight)
    {
        try {
            Float x = Float.parseFloat(workerHeight);
            if (x > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    public static boolean validateWorkerColor(String workerColor) {
        return (workerColor.equals("RED")
                || workerColor.equals("BLACK")
                || workerColor.equals("YELLOW")
                || workerColor.equals("GREEN")
                || workerColor.equals("BLUE")
                || workerColor.equals("WHITE"));
    }

    public static boolean validateWorkerCountry(String workerCountry)
    {
        return workerCountry.equals("ITALY") ||
                workerCountry.equals("THAILAND") ||
                workerCountry.equals("NORTH_KOREA");
    }

}
