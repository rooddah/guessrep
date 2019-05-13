package pages;

import java.util.Arrays;
import java.util.List;

public abstract class BasePage {

    public abstract String getPageTitle();

    public enum Titles {
        MR("Mr."),
        MRS("Mrs.");

        private String name;

        Titles(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return name;
        }
    }

    public enum Months {
        JANUARY("1"),
        FEBRUARY("2"),
        MARCH("3"),
        APRIL("4"),
        MAY("5"),
        JUNE("6"),
        JULY("7"),
        AUGUST("8"),
        SEPTEMBER("9"),
        OCTOBER("10"),
        NOVEMBER("11"),
        DECEMBER("12");

        private String name;

        Months(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return name;
        }
    }

    public enum Countries {
        UNITED_STATES("United States");

        private String name;

        Countries(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return name;
        }
    }

    public enum States {

        ALABAMA("Alabama"),
        ALASKA("Alaska"),
        ARIZONA("Arizona"),
        ARKANSAS("Arkansas"),
        CALIFORNIA("California"),
        COLORADO("Colorado"),
        CONNECTICUT("Connecticut"),
        DELAWARE("Delaware"),
        DISTRICT_OF_COLUMBIA("District of Columbia"),
        FLORIDA("Florida"),
        GEORGIA("Georgia"),
        HAWAII("Hawaii"),
        IDAHO("Idaho"),
        ILLINOIS("Illinois"),
        INDIANA("Indiana"),
        IOWA("Iowa"),
        KANSAS("Kansas"),
        KENTUCKY("Kentucky"),
        LOUISIANA("Louisiana"),
        MAINE("Maine"),
        MARYLAND("Maryland"),
        MASSACHUSETTS("Massachusetts"),
        MICHIGAN("Michigan"),
        MINNESOTA("Minnesota"),
        MISSISSIPPI("Mississippi"),
        MISSOURI("Missouri"),
        MONTANA("Montana"),
        NEBRASKA("Nebraska"),
        NEVADA("Nevada"),
        NEW_HAMPSHIRE("New Hampshire"),
        NEW_JERSEY("New Jersey"),
        NEW_MEXICO("New Mexico"),
        NEW_YORK("New York"),
        NORTH_CAROLINA("North Carolina"),
        NORTH_DAKOTA("North Dakota"),
        OHIO("Ohio"),
        OKLAHOMA("Oklahoma"),
        OREGON("Oregon"),
        PENNSYLVANIA("Pennsylvania"),
        RHODE_ISLAND("Rhode Island"),
        SOUTH_CAROLINA("South Carolina"),
        SOUTH_DAKOTA("South Dakota"),
        TENNESSEE("Tennessee"),
        TEXAS("Texas"),
        US_VIRGIN_ISLANDS("US Virgin Islands"),
        UTAH("Utah"),
        VERMONT("Vermont"),
        VIRGINIA("Virginia"),
        WASHINGTON("Washington"),
        WEST_VIRGINIA("West Virginia"),
        WISCONSIN("Wisconsin"),
        WYOMING("Wyoming");

        private String name;

        States (String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return name;
        }
    }

    public List<String> errorMessages = Arrays.asList(
            "You must register at least one phone number.",
            "lastname is required.",
            "firstname is required.",
            "passwd is required.",
            "address1 is required.",
            "city is required.",
            "The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
            "This country requires you to choose a State."
    );
}
