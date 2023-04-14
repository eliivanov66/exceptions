public class Extractor {
    public static User extractData(String argString, int dataLenght) throws MyDataLenghtException, MyDataFormatException {
        boolean badData = false;
        String [] rawData = argString.split(" ");
        String surName; //0
        String firstName; //1
        String fatherName; //2
        String birthDate; //3
        Long phoneNumber; //4
        char gender; //5
        User retValue = null;

        if ((rawData == null) || (rawData.length != dataLenght)) {
            badData = true;
            throw new MyDataLenghtException("Введённые данные не имеют нужной длины");         
        } else {
            surName = rawData[0].toLowerCase();
            firstName = rawData[1].toLowerCase();
            fatherName = rawData[2].toLowerCase();
            birthDate = rawData[3];

            birthDate = birthDate.replace(".", "/");
            String[] birthDateTemp = birthDate.split("/");
            if ((birthDateTemp == null) || (birthDateTemp.length != 3)) {
                badData = true;
                throw new MyDataFormatException("Некорректная дата (необходим формат dd.mm.yyyy): " + birthDate);
            } else {
                int temp;
                try {
                    temp = Integer.parseInt(birthDateTemp[0]);
                    if (temp < 1 || temp > 31) {
                        badData = true;
                        throw new MyDataFormatException("Некорректная дата (день указан некорректно): " + birthDateTemp[0]); 
                    }
                } catch (NumberFormatException e) {
                    badData = true;
                    throw new MyDataFormatException("Некорректная дата (день указан некорректно): " + birthDateTemp[0]);  
                }
                try {
                    temp = Integer.parseInt(birthDateTemp[1]);
                    if (temp < 1 || temp > 12) {
                        badData = true;
                        throw new MyDataFormatException("Некорректная дата (месяц указан некорректно): " + birthDateTemp[1]); 
                    }
                } catch (NumberFormatException e) {
                    badData = true;
                    throw new MyDataFormatException("Некорректная дата (месяц указан некорректно): " + birthDateTemp[1]);  
                }
                try {
                    temp = Integer.parseInt(birthDateTemp[2]);
                    if (temp < 0 || (long) temp > System.currentTimeMillis() / 31536000000L + 1970L) {
                        badData = true;
                        throw new MyDataFormatException("Некорректная дата (год указан некорректно): " + birthDateTemp[2]); 
                    }
                } catch (NumberFormatException e) {
                    badData = true;
                    throw new MyDataFormatException("Некорректная дата (год указан некорректно): " + birthDateTemp[2]);  
                }
            }

            try {
                phoneNumber = Long.valueOf(rawData[4]);
                if (phoneNumber < 0){
                    badData = true;
                    throw new MyDataFormatException("Некорректный номер телефона: " + rawData[4]);
                }
            } catch (NumberFormatException e) {
                badData = true;
                throw new MyDataFormatException("Некорректный номер телефона: " + rawData[4]);
            }
            
            try {
                gender = rawData[5].toLowerCase().charAt(0);
                if ((gender != 'm') && (gender != 'f')) {
                    badData = true;
                    throw new MyDataFormatException("Пол указан некорректно (необходим m или f): " + rawData[5]);
                }
            } catch (Exception e) {
                badData = true;
                throw new MyDataFormatException("Пол указан некорректно (необходим m или f): " + rawData[5]);
            }
            
            if (! badData ) {
                retValue = new User(surName, firstName, fatherName, birthDate, phoneNumber, gender);
            } 

        }
        return retValue;
    }

    public static String packData(User user) throws MyDataFormatException  {
        String retValue = null;
        if (user == null) {
            throw new MyDataFormatException("Данные пользователя невозможно упаковать для отправки в файл");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<f>".replace("f", user.getSurName()));
            stringBuilder.append("<f>".replace("f", user.getFirstName()));
            stringBuilder.append("<f>".replace("f", user.getFatherName()));
            stringBuilder.append("<f>".replace("f", user.getBirthDate()));
            stringBuilder.append("<f>".replace("f", String.valueOf(user.getPhoneNumber().toString())));
            stringBuilder.append("<f>".replace("f", String.valueOf(user.getGender())));
            retValue = stringBuilder.toString();
            System.out.println(retValue);
        }
        return retValue;
    }
}
