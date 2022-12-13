package BDD;

import java.util.regex.*;

public class Connexion {
	
        //Variables d'instance
        private String ip;
        private String date;
        private String heure;
        private String appareil;
        private String os;
        private String navigateur;
        private String url;
        private int code;  
        private String info;
            
        // Regex
        private static Pattern ipPattern = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
        private static Pattern datePattern = Pattern.compile("[0-9]{1,2}\\/[-a-zA-Z]{3}/[0-9]{1,4}");
        private static Pattern heurePattern = Pattern.compile(":[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}");
        private static Pattern urlPattern = Pattern.compile("http(s)?://(www.)?[-a-zA-Z0-9]+.[a-zA-Z0-9]{1,6}[-a-zA-Z0-9/*.]*");
        private static Pattern codePattern = Pattern.compile(" [1-5][0-9][0-9] ");
        private static Pattern infoPattern = Pattern.compile("((GET)|(POST)) /[-a-zA-Z0-9!\"#$%&'()*+,./:;<=>?@\\^_`{|}~-]+ HTTP/1.[0-3]");
        
        // Constructeur
        public Connexion(String oneLine) {
        	
            // Definir IP
            Matcher ip = ipPattern.matcher(oneLine);
            if (ip.find()) {
                this.ip = oneLine.substring(ip.start(), ip.end());
            }
            
            // Definir date
            Matcher date = datePattern.matcher(oneLine);
            if(date.find()) {
            	this.date = oneLine.substring(date.start(), date.end());
            }else {
            	this.date = "-";
            }            
  
            // Definir l'heure
            Matcher heure = heurePattern.matcher(oneLine);
            if(heure.find()) {
            	this.heure = oneLine.substring(heure.start()+1, heure.end());
            }else {
            	this.heure = "-";
            }
           
            //Definir appareil
            if(oneLine.contains("Mobile")) {
            	this.appareil = "Mobile";
            }else {
                this.appareil = "PC";
            }
            
            //Definir OS
            this.os="Other";
            if(oneLine.contains("linux")) {
            	this.os="linux";
            }
            if(oneLine.contains("Mac")) {
            	this.os="Mac";
            }
            if(oneLine.contains("Windows")) {
                this.os="Windows";
            }
            if(oneLine.contains("ios")) {
                this.os="ios";
            }
            if(oneLine.contains("android")) {
                this.os="android";
            }   
            
            //Definir Navigateur            
            this.navigateur="Other";
            if(oneLine.contains("Safari")) {
            	this.navigateur="Safari";
            }
            if(oneLine.contains("Chrome")) {
            	this.navigateur="Chrome";
            }
            if(oneLine.contains("Firefox")) {
                this.navigateur="Firefox";
            }
            if(oneLine.contains("Internet Explorer")) {
                this.navigateur="Internet Explorer";
            }
            if(oneLine.contains("Microsoft Edge")) {
                this.navigateur="Microsoft Edge";
            }   
                                 
            
            // Definir URL
            Matcher url = urlPattern.matcher(oneLine);
            if (url.find()) {
                this.url = oneLine.substring(url.start(), url.end());
            }else {
                this.url = "-";
            }
            
            // Definir code
            Matcher code = codePattern.matcher(oneLine);
            if (code.find()) {
                this.code = Integer.parseInt(oneLine.substring(code.start(), code.end()).trim());
            }
                           
            //Definir Info
            Matcher info = infoPattern.matcher(oneLine);
            if(info.find()) {
                this.info = oneLine.substring(info.start(),info.end());
            }     
           
        }
        // Methodes pour afficher
        public void afficherIp() {
        	System.out.println("IP : " + ip);
    	}
    	public void afficherDate() {
    		System.out.println("Après formatage : " + getDate());
    	}
        public void afficherAppareil() {
            System.out.println("Appareil : " + appareil);
        }
        public void afficherOs() {
            System.out.println("OS : "+ os);
        }
        public void afficherUrl() {
            System.out.println("URL : " + url);
        } 
        public void afficherCode() {
            System.out.println("Code : " + (code >= 400 ? "Error " : "") + code);
        }
        public void afficherNavigateur() {
            System.out.println("Navigateur : " + navigateur);
        }
        public void afficherInfo() {
            System.out.println("Info : " + info);
        }
        
        //Methode pour obtenir
        public String getIp(){
            return ip;
        }
        public String getDate() {
            int separateMonth = date.indexOf("/", 3);
            String month = date.substring(3, separateMonth);
            String monthNb = "0";
            
            if(month.equals("Jan"))
                monthNb = "01";
            
            if(month.equals("Feb"))
                monthNb = "02";
            
            if(month.equals("Mar"))
                monthNb = "03";
            
            if(month.equals("Apr"))
                monthNb = "04";
            
            if(month.equals("May"))
                monthNb = "05";
            
            if(month.equals("Jun"))
                monthNb = "06";
            
            if(month.equals("Jul"))
                monthNb = "07";
            
            if(month.equals("Aug"))
                monthNb = "08";
            
            if(month.equals("Sep"))
                monthNb = "09";
            
            if(month.equals("Oct"))
                monthNb = "10";
            
            if(month.equals("Nov"))
                monthNb = "11";
            
            if(month.equals("Dec"))
                monthNb = "12";
            
            return (date.substring(0, 2) + '-' + monthNb + "-" +date.substring(7, 11));
        }
           
        public String getHeure() {
    		return heure;   		
    	}
        public String getAppareil() {
            return appareil;            
        }
        public String getOS() {
            return os;
        }
        public String getNavigateur() {
        	return navigateur;
        }  
        public int getCode(){
            return code;
        }   
        public String getInfo() {
        	return info;
        }
        public String getUrl() {
        	return url;
        }          
}


