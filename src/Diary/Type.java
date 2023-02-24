package Diary;

public enum Type {
        WORK("work"),
        PERSONAL("personal");
        public final String typeTask;

        Type(String typeTask) {
            this.typeTask = typeTask;
        }

        public String getTypeTask() {
            return typeTask;
        }
    }
