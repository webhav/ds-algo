package com.webhav.dsalgo.backtracking;

public class Test {
	
	//static String[] msisdns = {"917737541581","917870429075","917894792891","917995244317","918096480132","918334944047","918354038846","919440697743","919654899149","919936735252"};
	
	static String[] msisdns = {"917794843151","917798854728","918447953794","919154626537","919326969636","919640782214","919711490264","919728004858","919885755168","919926529444"}; 
	
	//static String[] buckets = {"pnwgkbeanscash_Daily_17082018","pnwgkbeanscash_Weekly_17082018","pnwgkbeanscash_AllTime","Easywin_Daily_17082018","Easywin_Weekly_17082018","Easywin_AllTime","Allformats_Daily_17082018","Allformats_Weekly_17082018","Allformats_Weekly_18082018","Allformats_Weekly_19082018","Allformats_AllTime"};
	
	static String[] buckets = {"pnwlogobeancash_Daily_17082018","pnwlogobeancash_Weekly_17082018","pnwlogobeancash_AllTime","Easywin_Daily_17082018","Easywin_Weekly_17082018","Easywin_AllTime","Allformats_Daily_17082018","Allformats_Weekly_17082018","Allformats_Weekly_18082018","Allformats_Weekly_19082018","Allformats_AllTime"};
	
	public static void main(String[] args) {
		
		for(String msisdn : msisdns) {
			for(String bucket: buckets) {				
				System.out.println("zrem " + bucket + " " + msisdn);
			}
		}
		
	}

}
