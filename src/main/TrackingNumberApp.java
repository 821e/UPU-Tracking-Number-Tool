import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrackingNumberApp extends JFrame {
    private static final Map<String, String[]> services = new HashMap<>();
    private static final Map<String, String> isoCountries = new HashMap<>();
    private static final String[][] SICodes = {
            { "AV", "AZ", "Domestic, bilateral, multilateral use only, identifying RFID-tracked e-commerce items" },
            { "BA", "BZ", "Domestic, bilateral, multilateral use only" },
            { "CA", "CZ", "Parcel post; the use of CZ requires bilateral agreement" },
            { "DA", "DZ", "For domestic, bilateral, multilateral use only" },
            { "EA", "EZ", "EMS; the use of EX-EZ requires bilateral agreement" },
            { "GA", "GZ", "For domestic, bilateral, multilateral use only" },
            { "HA", "HZ", "E-commerce parcels; the use of HX-HY requires multilateral agreement" },
            { "JA", "JZ", "Reserved; cannot be assigned as valid service indicator values" },
            { "KA", "KZ", "Reserved; cannot be assigned as valid service indicator values" },
            { "LA", "LZ", "Letter post express; the use of LZ requires bilateral agreement" },
            { "MA", "MZ", "Letter post: M bags" },
            { "NA", "NZ", "For domestic, bilateral, multilateral use only" },
            { "PA", "PZ", "For domestic, bilateral, multilateral use only" },
            { "QA", "QM", "Letter post: IBRS (International Business Reply Service)" },
            { "RA", "RZ", "Letter post: registered, but not insured delivery. The use of RZ requires bilateral agreement." },
            { "SA", "SZ", "Reserved; cannot be assigned as valid service indicator values" },
            { "TA", "TZ", "Reserved; cannot be assigned as valid service indicator values" },
            { "UA", "UZ", "Letter post: items other than LA-LZ (Express), MA-MZ (M bags), QA-QM (IBRS), RA-RZ (registered), VA-VZ (insured), subject to customs control, i.e. bearing a CN 22 or CN 23" },
            { "VA", "VZ", "Letter post insured; the use of VZ requires bilateral agreement" },
            { "WA", "WZ", "Reserved; cannot be assigned as valid service indicator values" },
            { "ZA", "ZZ", "Domestic, bilateral, multilateral use only" }
    };

    static {
        services.put("China Post", new String[]{"CN", "RH", "RS"});
        services.put("India", new String[]{"IN", "ES", "RS", "CS"});
        services.put("USPS", new String[]{"US", "RA", "EA"});
        services.put("ePacket", new String[]{"CN", "LM"});
    
        isoCountries.put("US", "United States");
        isoCountries.put("CN", "China");
        isoCountries.put("IN", "India");
        isoCountries.put("ES", "Spain");
        isoCountries.put("RS", "Serbia");
        isoCountries.put("CS", "Serbia and Montenegro");
        isoCountries.put("EA", "United States");
        isoCountries.put("LM", "Lao People's Democratic Republic");
        isoCountries.put("AF", "Afghanistan");
        isoCountries.put("AX", "Aland Islands");
        isoCountries.put("AL", "Albania");
        isoCountries.put("DZ", "Algeria");
        isoCountries.put("AS", "American Samoa");
        isoCountries.put("AD", "Andorra");
        isoCountries.put("AO", "Angola");
        isoCountries.put("AI", "Anguilla");
        isoCountries.put("AQ", "Antarctica");
        isoCountries.put("AG", "Antigua And Barbuda");
        isoCountries.put("AR", "Argentina");
        isoCountries.put("AM", "Armenia");
        isoCountries.put("AW", "Aruba");
        isoCountries.put("AU", "Australia");
        isoCountries.put("AT", "Austria");
        isoCountries.put("AZ", "Azerbaijan");
        isoCountries.put("BS", "Bahamas");
        isoCountries.put("BH", "Bahrain");
        isoCountries.put("BD", "Bangladesh");
        isoCountries.put("BB", "Barbados");
        isoCountries.put("BY", "Belarus");
        isoCountries.put("BE", "Belgium");
        isoCountries.put("BZ", "Belize");
        isoCountries.put("BJ", "Benin");
        isoCountries.put("BM", "Bermuda");
        isoCountries.put("BT", "Bhutan");
        isoCountries.put("BO", "Bolivia");
        isoCountries.put("BA", "Bosnia And Herzegovina");
        isoCountries.put("BW", "Botswana");
        isoCountries.put("BV", "Bouvet Island");
        isoCountries.put("BR", "Brazil");
        isoCountries.put("IO", "British Indian Ocean Territory");
        isoCountries.put("BN", "Brunei Darussalam");
        isoCountries.put("BG", "Bulgaria");
        isoCountries.put("BF", "Burkina Faso");
        isoCountries.put("BI", "Burundi");
        isoCountries.put("KH", "Cambodia");
        isoCountries.put("CM", "Cameroon");
        isoCountries.put("CA", "Canada");
        isoCountries.put("CV", "Cape Verde");
        isoCountries.put("KY", "Cayman Islands");
        isoCountries.put("CF", "Central African Republic");
        isoCountries.put("TD", "Chad");
        isoCountries.put("CL", "Chile");
        isoCountries.put("CX", "Christmas Island");
        isoCountries.put("CC", "Cocos (Keeling) Islands");
        isoCountries.put("CO", "Colombia");
        isoCountries.put("KM", "Comoros");
        isoCountries.put("CG", "Congo");
        isoCountries.put("CD", "Congo, Democratic Republic");
        isoCountries.put("CK", "Cook Islands");
        isoCountries.put("CR", "Costa Rica");
        isoCountries.put("CI", "Cote D'Ivoire");
        isoCountries.put("HR", "Croatia");
        isoCountries.put("CU", "Cuba");
        isoCountries.put("CY", "Cyprus");
        isoCountries.put("CZ", "Czech Republic");
        isoCountries.put("DK", "Denmark");
        isoCountries.put("DJ", "Djibouti");
        isoCountries.put("DM", "Dominica");
        isoCountries.put("DO", "Dominican Republic");
        isoCountries.put("EC", "Ecuador");
        isoCountries.put("EG", "Egypt");
        isoCountries.put("SV", "El Salvador");
        isoCountries.put("GQ", "Equatorial Guinea");
        isoCountries.put("ER", "Eritrea");
        isoCountries.put("EE", "Estonia");
        isoCountries.put("ET", "Ethiopia");
        isoCountries.put("FK", "Falkland Islands (Malvinas)");
        isoCountries.put("FO", "Faroe Islands");
        isoCountries.put("FJ", "Fiji");
        isoCountries.put("FI", "Finland");
        isoCountries.put("FR", "France");
        isoCountries.put("GF", "French Guiana");
        isoCountries.put("PF", "French Polynesia");
        isoCountries.put("TF", "French Southern Territories");
        isoCountries.put("GA", "Gabon");
        isoCountries.put("GM", "Gambia");
        isoCountries.put("GE", "Georgia");
        isoCountries.put("DE", "Germany");
        isoCountries.put("GH", "Ghana");
        isoCountries.put("GI", "Gibraltar");
        isoCountries.put("GR", "Greece");
        isoCountries.put("GL", "Greenland");
        isoCountries.put("GD", "Grenada");
        isoCountries.put("GP", "Guadeloupe");
        isoCountries.put("GU", "Guam");
        isoCountries.put("GT", "Guatemala");
        isoCountries.put("GG", "Guernsey");
        isoCountries.put("GN", "Guinea");
        isoCountries.put("GW", "Guinea-Bissau");
        isoCountries.put("GY", "Guyana");
        isoCountries.put("HT", "Haiti");
        isoCountries.put("HM", "Heard Island & Mcdonald Islands");
        isoCountries.put("VA", "Holy See (Vatican City State)");
        isoCountries.put("HN", "Honduras");
        isoCountries.put("HK", "Hong Kong");
        isoCountries.put("HU", "Hungary");
        isoCountries.put("IS", "Iceland");
        isoCountries.put("ID", "Indonesia");
        isoCountries.put("IR", "Iran, Islamic Republic Of");
        isoCountries.put("IQ", "Iraq");
        isoCountries.put("IE", "Ireland");
        isoCountries.put("IM", "Isle Of Man");
        isoCountries.put("IL", "Israel");
        isoCountries.put("IT", "Italy");
        isoCountries.put("JM", "Jamaica");
        isoCountries.put("JP", "Japan");
        isoCountries.put("JE", "Jersey");
        isoCountries.put("JO", "Jordan");
        isoCountries.put("KZ", "Kazakhstan");
        isoCountries.put("KE", "Kenya");
        isoCountries.put("KI", "Kiribati");
        isoCountries.put("KR", "Korea");
        isoCountries.put("KW", "Kuwait");
        isoCountries.put("KG", "Kyrgyzstan");
        isoCountries.put("LA", "Lao People's Democratic Republic");
        isoCountries.put("LV", "Latvia");
        isoCountries.put("LB", "Lebanon");
        isoCountries.put("LS", "Lesotho");
        isoCountries.put("LR", "Liberia");
        isoCountries.put("LY", "Libyan Arab Jamahiriya");
        isoCountries.put("LI", "Liechtenstein");
        isoCountries.put("LT", "Lithuania");
        isoCountries.put("LU", "Luxembourg");
        isoCountries.put("MO", "Macao");
        isoCountries.put("MK", "Macedonia");
        isoCountries.put("MG", "Madagascar");
        isoCountries.put("MW", "Malawi");
        isoCountries.put("MY", "Malaysia");
        isoCountries.put("MV", "Maldives");
        isoCountries.put("ML", "Mali");
        isoCountries.put("MT", "Malta");
        isoCountries.put("MH", "Marshall Islands");
        isoCountries.put("MQ", "Martinique");
        isoCountries.put("MR", "Mauritania");
        isoCountries.put("MU", "Mauritius");
        isoCountries.put("YT", "Mayotte");
        isoCountries.put("MX", "Mexico");
        isoCountries.put("FM", "Micronesia, Federated States Of");
        isoCountries.put("MD", "Moldova");
        isoCountries.put("MC", "Monaco");
        isoCountries.put("MN", "Mongolia");
        isoCountries.put("ME", "Montenegro");
        isoCountries.put("MS", "Montserrat");
        isoCountries.put("MA", "Morocco");
        isoCountries.put("MZ", "Mozambique");
        isoCountries.put("MM", "Myanmar");
        isoCountries.put("NA", "Namibia");
        isoCountries.put("NR", "Nauru");
        isoCountries.put("NP", "Nepal");
        isoCountries.put("NL", "Netherlands");
        isoCountries.put("AN", "Netherlands Antilles");
        isoCountries.put("NC", "New Caledonia");
        isoCountries.put("NZ", "New Zealand");
        isoCountries.put("NI", "Nicaragua");
        isoCountries.put("NE", "Niger");
        isoCountries.put("NG", "Nigeria");
        isoCountries.put("NU", "Niue");
        isoCountries.put("NF", "Norfolk Island");
        isoCountries.put("MP", "Northern Mariana Islands");
        isoCountries.put("NO", "Norway");
        isoCountries.put("OM", "Oman");
        isoCountries.put("PK", "Pakistan");
        isoCountries.put("PW", "Palau");
        isoCountries.put("PS", "Palestinian Territory, Occupied");
        isoCountries.put("PA", "Panama");
        isoCountries.put("PG", "Papua New Guinea");
        isoCountries.put("PY", "Paraguay");
        isoCountries.put("PE", "Peru");
        isoCountries.put("PH", "Philippines");
        isoCountries.put("PN", "Pitcairn");
        isoCountries.put("PL", "Poland");
        isoCountries.put("PT", "Portugal");
        isoCountries.put("PR", "Puerto Rico");
        isoCountries.put("QA", "Qatar");
        isoCountries.put("RE", "Reunion");
        isoCountries.put("RO", "Romania");
        isoCountries.put("RU", "Russian Federation");
        isoCountries.put("RW", "Rwanda");
        isoCountries.put("BL", "Saint Barthelemy");
        isoCountries.put("SH", "Saint Helena");
        isoCountries.put("KN", "Saint Kitts And Nevis");
        isoCountries.put("LC", "Saint Lucia");
        isoCountries.put("MF", "Saint Martin");
        isoCountries.put("PM", "Saint Pierre And Miquelon");
        isoCountries.put("VC", "Saint Vincent And Grenadines");
        isoCountries.put("WS", "Samoa");
        isoCountries.put("SM", "San Marino");
        isoCountries.put("ST", "Sao Tome And Principe");
        isoCountries.put("SA", "Saudi Arabia");
        isoCountries.put("SN", "Senegal");
        isoCountries.put("SC", "Seychelles");
        isoCountries.put("SL", "Sierra Leone");
        isoCountries.put("SG", "Singapore");
        isoCountries.put("SK", "Slovakia");
        isoCountries.put("SI", "Slovenia");
        isoCountries.put("SB", "Solomon Islands");
        isoCountries.put("SO", "Somalia");
        isoCountries.put("ZA", "South Africa");
        isoCountries.put("GS", "South Georgia And Sandwich Isl.");
        isoCountries.put("LK", "Sri Lanka");
        isoCountries.put("SD", "Sudan");
        isoCountries.put("SR", "Suriname");
        isoCountries.put("SJ", "Svalbard And Jan Mayen");
        isoCountries.put("SZ", "Swaziland");
        isoCountries.put("SE", "Sweden");
        isoCountries.put("CH", "Switzerland");
        isoCountries.put("SY", "Syrian Arab Republic");
        isoCountries.put("TW", "Taiwan");
        isoCountries.put("TJ", "Tajikistan");
        isoCountries.put("TZ", "Tanzania");
        isoCountries.put("TH", "Thailand");
        isoCountries.put("TL", "Timor-Leste");
        isoCountries.put("TG", "Togo");
        isoCountries.put("TK", "Tokelau");
        isoCountries.put("TO", "Tonga");
        isoCountries.put("TT", "Trinidad And Tobago");
        isoCountries.put("TN", "Tunisia");
        isoCountries.put("TR", "Turkey");
        isoCountries.put("TM", "Turkmenistan");
        isoCountries.put("TC", "Turks And Caicos Islands");
        isoCountries.put("TV", "Tuvalu");
        isoCountries.put("UG", "Uganda");
        isoCountries.put("UA", "Ukraine");
        isoCountries.put("AE", "United Arab Emirates");
        isoCountries.put("GB", "United Kingdom");
        isoCountries.put("UM", "United States Outlying Islands");
        isoCountries.put("UY", "Uruguay");
        isoCountries.put("UZ", "Uzbekistan");
        isoCountries.put("VU", "Vanuatu");
        isoCountries.put("VE", "Venezuela");
        isoCountries.put("VN", "Viet Nam");
        isoCountries.put("VG", "Virgin Islands, British");
        isoCountries.put("VI", "Virgin Islands, U.S.");
        isoCountries.put("WF", "Wallis And Futuna");
        isoCountries.put("EH", "Western Sahara");
        isoCountries.put("YE", "Yemen");
        isoCountries.put("ZM", "Zambia");
        isoCountries.put("ZW", "Zimbabwe");
    }
    

    private JComboBox<String> serviceComboBox;
    private JTextField ccField, siField, sfField, nField;
    private JTextArea resultArea;
    private JButton generateButton, verifyButton;

    public TrackingNumberApp() {
        setTitle("Tracking Number Generator and Checker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(6, 2));

        serviceComboBox = new JComboBox<>(services.keySet().toArray(new String[0]));
        serviceComboBox.addActionListener(new ServiceSelectorListener());

        ccField = new JTextField();
        siField = new JTextField();
        sfField = new JTextField();
        nField = new JTextField("10");

        generateButton = new JButton("Generate");
        generateButton.addActionListener(new GenerateButtonListener());

        verifyButton = new JButton("Verify");
        verifyButton.addActionListener(new VerifyButtonListener());

        controlPanel.add(new JLabel("Service:"));
        controlPanel.add(serviceComboBox);
        controlPanel.add(new JLabel("Country Code:"));
        controlPanel.add(ccField);
        controlPanel.add(new JLabel("Service Indicator:"));
        controlPanel.add(siField);
        controlPanel.add(new JLabel("Start from (first 8 digits):"));
        controlPanel.add(sfField);
        controlPanel.add(new JLabel("Quantity:"));
        controlPanel.add(nField);
        controlPanel.add(generateButton);
        controlPanel.add(verifyButton);

        resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize fields based on selected service
        selectService();
    }

    private void selectService() {
        String selectedService = (String) serviceComboBox.getSelectedItem();
        if (selectedService != null) {
            String[] serviceInfo = services.get(selectedService);
            if (serviceInfo != null) {
                ccField.setText(serviceInfo[0]);
                siField.setText(serviceInfo[1]);
            }
        }
    }

    private String generateSerial() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        String sn = sb.toString();
        int cs = calculateChecksum(sn);
        return sn + cs;
    }

    private int calculateChecksum(String sn) {
        int[] weight = {8, 6, 4, 2, 3, 5, 9, 7};
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += Character.getNumericValue(sn.charAt(i)) * weight[i];
        }
        int cs = 11 - (sum % 11);
        return cs == 10 ? 0 : (cs == 11 ? 5 : cs);
    }

    private class ServiceSelectorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectService();
        }
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int quantity = Integer.parseInt(nField.getText());
                String cc = ccField.getText();
                String si = siField.getText();
                String sf = sfField.getText();
                StringBuilder result = new StringBuilder();

                if (sf.isEmpty()) {
                    for (int i = 0; i < quantity; i++) {
                        result.append(si).append(generateSerial()).append(cc).append("\n");
                    }
                } else {
                    if (sf.length() == 8) {
                        int serial = Integer.parseInt(sf);
                        for (int i = 0; i < quantity; i++) {
                            String sn = String.format("%08d", serial);
                            int cs = calculateChecksum(sn);
                            result.append(si).append(sn).append(cs).append(cc).append("\n");
                            serial++;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Start from (first 8 digits) must be 8 digits.");
                        return;
                    }
                }
                resultArea.setText(result.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantity must be a number.");
            }
        }
    }

    private class VerifyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] lines = resultArea.getText().split("\\n");
            StringBuilder result = new StringBuilder();
            int passed = 0; // Counter for passed tracking numbers
            int failed = 0; // Counter for failed tracking numbers
    
            for (String line : lines) {
                if (line.isEmpty()) continue;
                String error = "";
                String info = "";
    
                if (!line.matches("^[A-Z]{2}\\d{8}\\d[A-Z]{2}$")) {
                    error = "Wrong format";
                } else {
                    String si = line.substring(0, 2);
                    String sn = line.substring(2, 10);
                    int cs = Character.getNumericValue(line.charAt(10));
                    String cc = line.substring(11, 13);
                    int csReal = calculateChecksum(sn);
    
                    if (cs != csReal) {
                        error = "Wrong Checksum";
                    }
    
                    String countryName = isoCountries.getOrDefault(cc, cc);
                    String siCode = getSICode(si);
                    info = "Country: " + countryName + ", SI Code: " + siCode;
                }
    
                if (error.isEmpty()) {
                    passed++;
                    result.append(line).append(" - OK - ").append(info).append("\n");
                } else {
                    failed++;
                    result.append(line).append(" - ").append(error).append(" - ").append(info).append("\n");
                }
            }
    
            result.append("\n").append("Passed: ").append(passed).append(", Failed: ").append(failed);
            resultArea.setText(result.toString());
        }
    
        private String getSICode(String si) {
            for (String[] siCode : SICodes) {
                if (si.compareTo(siCode[0]) >= 0 && si.compareTo(siCode[1]) <= 0) {
                    return siCode[2];
                }
            }
            return "Invalid SI";
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrackingNumberApp app = new TrackingNumberApp();
            app.setVisible(true);
        });
    }
}
