// 1700から1999まで解析し2000から2015まで予想

public class Sunspots {
	public static void main(String[] args) {
		// 問題2
		int t, T=300, Tdata=316;
		//Data
		double data[][]={{1700.5,5.0},{1701.5,11.0},{1702.5,16.0},{1703.5,23.0},{1704.5,36.0},{1705.5,58.0},{1706.5,29.0},{1707.5,20.0},
				{1708.5,10.0},{1709.5,8.0},{1710.5,3.0},{1711.5,0.0},{1712.5,0.0},{1713.5,2.0},{1714.5,11.0},{1715.5,27.0},{1716.5,47.0},{1717.5,63.0},{1718.5,60.0},{1719.5,39.0},{1720.5,28.0},{1721.5,26.0},{1722.5,22.0},{1723.5,11.0},
				{1724.5,21.0},{1725.5,40.0},{1726.5,78.0},{1727.5,122.0},{1728.5,103.0},{1729.5,73.0},{1730.5,47.0},{1731.5,35.0},
				{1732.5,11.0},{1733.5,5.0},{1734.5,16.0},{1735.5,34.0},{1736.5,70.0},{1737.5,81.0},{1738.5,111.0},
				{1739.5,101.0},{1740.5,73.0},{1741.5,40.0},{1742.5,20.0},{1743.5,16.0},{1744.5,5.0},{1745.5,11.0},{1746.5,22.0},{1747.5,40.0},{1748.5,60.0},{1749.5,80.9},{1750.5,83.4},{1751.5,47.7},{1752.5,47.8},{1753.5,30.7},{1754.5,12.2},
				{1755.5,9.6},{1756.5,10.2},{1757.5,32.4},{1758.5,47.6},{1759.5,54.0},{1760.5,62.9},{1761.5,85.9},{1762.5,61.2},
				{1763.5,45.1},{1764.5,36.4},{1765.5,20.9},{1766.5,11.4},{1767.5,37.8},{1768.5,69.8},
				{1769.5,106.1},{1770.5,100.8},{1771.5,81.6},{1772.5,66.5},{1773.5,34.8},{1774.5,30.6},{1775.5,7.0},{1776.5,19.8},{1777.5,92.5},{1778.5,154.4},{1779.5,125.9},{1780.5,84.8},{1781.5,68.1},{1782.5,38.5},{1783.5,22.8},{1784.5,10.2},
				{1785.5,24.1},{1786.5,82.9},{1787.5,132.0},{1788.5,130.9},{1789.5,118.1},{1790.5,89.9},{1791.5,66.6},{1792.5,60.0},
				{1793.5,46.9},{1794.5,41.0},{1795.5,21.3},{1796.5,16.0},{1797.5,6.4},{1798.5,4.1},
				{1799.5,6.8},{1800.5,14.5},{1801.5,34.0},{1802.5,45.0},{1803.5,43.1},{1804.5,47.5},{1805.5,42.2},{1806.5,28.1},{1807.5,10.1},{1808.5,8.1},{1809.5,2.5},{1810.5,0.0},{1811.5,1.4},{1812.5,5.0},{1813.5,12.2},{1814.5,13.9},
				{1815.5,35.4},{1816.5,45.8},{1817.5,41.0},{1818.5,30.1},{1819.5,23.9},{1820.5,15.6},
				{1821.5,6.6},{1822.5,4.0},{1823.5,1.8},{1824.5,8.5},{1825.5,16.6},{1826.5,36.3},{1827.5,49.6},{1828.5,64.2},{1829.5,67.0},{1830.5,70.9},{1831.5,47.8},{1832.5,27.5},{1833.5,8.5},{1834.5,13.2},{1835.5,56.9},{1836.5,121.5},
				{1837.5,138.3},{1838.5,103.2},{1839.5,85.7},{1840.5,64.6},{1841.5,36.7},{1842.5,24.2},{1843.5,10.7},{1844.5,15.0},
				{1845.5,40.1},{1846.5,61.5},{1847.5,98.5},{1848.5,124.7},{1849.5,96.3},{1850.5,66.6},{1851.5,64.5},
				{1852.5,54.1},{1853.5,39.0},{1854.5,20.6},{1855.5,6.7},{1856.5,4.3},{1857.5,22.7},{1858.5,54.8},{1859.5,93.8},{1860.5,95.8},{1861.5,77.2},{1862.5,59.1},{1863.5,44.0},{1864.5,47.0},{1865.5,30.5},{1866.5,16.3},{1867.5,7.3},
				{1868.5,37.6},{1869.5,74.0},{1870.5,139.0},{1871.5,111.2},{1872.5,101.6},{1873.5,66.2},{1874.5,44.7},{1875.5,17.0},
				{1876.5,11.3},{1877.5,12.4},{1878.5,3.4},{1879.5,6.0},{1880.5,32.3},{1881.5,54.3},{1882.5,59.7},{1883.5,63.7},
				{1884.5,63.5},{1885.5,52.2},{1886.5,25.4},{1887.5,13.1},{1888.5,6.8},{1889.5,6.3},{1890.5,7.1},{1891.5,35.6},
				{1892.5,73.0},{1893.5,85.1},{1894.5,78.0},{1895.5,64.0},{1896.5,41.8},{1897.5,26.2},{1898.5,26.7},{1899.5,12.1},{1900.5,9.5},{1901.5,2.7},{1902.5,5.0},{1903.5,24.4},{1904.5,42.0},{1905.5,63.5},{1906.5,53.8},{1907.5,62.0},
				{1908.5,48.5},{1909.5,43.9},{1910.5,18.6},{1911.5,5.7},{1912.5,3.6},{1913.5,1.4},{1914.5,9.6},{1915.5,47.4},
				{1916.5,57.1},{1917.5,103.9},{1918.5,80.6},{1919.5,63.6},{1920.5,37.6},{1921.5,26.1},{1922.5,14.2},{1923.5,5.8},{1924.5,16.7},
				{1925.5,44.3},{1926.5,63.9},{1927.5,69.0},{1928.5,77.8},{1929.5,64.9},{1930.5,35.7},{1931.5,21.2},{1932.5,11.1},{1933.5,5.7},{1934.5,8.7},{1935.5,36.1},{1936.5,79.7},{1937.5,114.4},{1938.5,109.6},{1939.5,88.8},{1940.5,67.8},
				{1941.5,47.5},{1942.5,30.6},{1943.5,16.3},{1944.5,9.6},{1945.5,33.2},{1946.5,92.6},{1947.5,151.6},{1948.5,136.3},
				{1949.5,134.7},{1950.5,83.9},{1951.5,69.4},{1952.5,31.5},{1953.5,13.9},{1954.5,4.4},{1955.5,38.0},{1956.5,141.7},
				{1957.5,190.2},{1958.5,184.8},{1959.5,159.0},{1960.5,112.3},{1961.5,53.9},{1962.5,37.6},{1963.5,27.9},{1964.5,10.2},
				{1965.5,15.1},{1966.5,47.0},{1967.5,93.7},{1968.5,105.9},{1969.5,105.5},{1970.5,104.5},{1971.5,66.6},{1972.5,68.9},{1973.5,38.0},{1974.5,34.5},{1975.5,15.5},{1976.5,12.6},{1977.5,27.5},{1978.5,92.5},{1979.5,155.4},{1980.5,154.6},
				{1981.5,140.5},{1982.5,115.9},{1983.5,66.6},{1984.5,45.9},{1985.5,17.9},{1986.5,13.4},{1987.5,29.2},{1988.5,100.2},
				{1989.5,157.6},{1990.5,142.6},{1991.5,145.7},{1992.5,94.3},{1993.5,54.6},{1994.5,29.9},{1995.5,17.5},{1996.5,8.6},
				{1997.5,21.5},{1998.5,64.3},{1999.5,93.3},{2000.5,119.6},{2001.5,111.0},{2002.5,104.0},{2003.5,63.7},{2004.5,40.4},
				{2005.5,29.8},{2006.5,15.2},{2007.5,7.5},{2008.5,2.9},{2009.5,3.1},{2010.5,16.5},{2011.5,55.7},{2012.5, 57.7},{2013.5, 64.9},{2014.5,79.0},{2015.5,41.8}};
		//logarithmic transformation
		double x[] = new double[Tdata];
		for(t=0;t<Tdata;t++) x[t]=Math.log(data[t][1]+1);
		// 結果表示
//		for(t=0;t<Tdata;t++){
//			System.out.println(data[t][0] + "\t" + x[t]);
//		}
		
		// 問題3(1)
		double mean=0;
		for(t=0;t<300;t++) mean += x[t];
		mean /= 300;
		double normalX[] = new double[300];
		for(t=0;t<300;t++){
			normalX[t] = x[t]-mean;
//			System.out.println(data[t][0] + "\t" + normalX[t]);
		}
		
		// 問題3(2)
		int Mmax=15;
		double[] R = new double[Mmax+1];
		for(int m=0;m<=Mmax;m++){
			R[m]=0;
			for(t=0;t<T-m;t++){
				R[m] += normalX[t] * normalX[t+m]; 
			}
			R[m] /= T;
//			System.out.println("R[" + m + "]=" + R[m]);
		}
		
		// 問題3(3)
		double a[][] = new double[Mmax+1][Mmax+1];
		double s[] = new double[Mmax+1];
		/// 分散(ﾚﾋﾞﾝｿﾝ･ｱﾙｺﾞﾘｽﾞﾑ2. より)
		s[0] = R[0];
		// 他のパラメータ(ﾚﾋﾞﾝｿﾝ･ｱﾙｺﾞﾘｽﾞﾑ3. より)
		for(int M=1;M<=Mmax;M++){
			// a[M][M]
			a[M][M]=R[M];
			for(int m=0;m<M;m++) a[M][M] -= a[M-1][m]*R[M-m];
			a[M][M] /= s[M-1];
			
			// a[M][m]
			for(int m=0;m<M;m++) a[M][m] = a[M-1][m]-a[M][M]*a[M-1][M-m]; 
			
			// s[M]
			s[M] = s[M-1]*(1-a[M][M]*a[M][M]);
		}
		// 結果表示
//		System.out.println("s[0]="+s[0]);
//		for(int i=1;i<=15;i++){
//			System.out.println("s[" + i + "]=" + s[i]);
//			for(int j=1;j<=i;j++){
//				System.out.println("a["+i + "][" + j + "]=" + a[i][j]);
//			}
//		}
		
		// 問題4
		//AIC
		double AIC[] = new double[Mmax+1];
		for(int M=0;M<=Mmax;M++){
			AIC[M] = T*Math.log(Math.abs(s[M])) + 2*(M+1);
//			System.out.println(M + "\t" + AIC[M]);
		}
		
		// 問題5
		int M=10;
		double XorY;
		double y[] = new double[Tdata];
		for(t=0;t<T;t++) y[t] = Math.log(data[t][1]+1)-mean;
		for(int i=0; i<=15 ; i++){
			y[300+i]=0;
			for(int j=1;j<=M;j++){
				if((300+i)-j >= 300){
					XorY = y[(300+i)-j];
				}else{
					XorY = normalX[(300+i)-j];
				}
				y[300+i] += (a[M][j] * XorY);
			}
		}
		/// 規格化解除
		for(t=0 ; t<=315 ; t++){
			y[t] += mean;
			y[t] = Math.exp(y[t]);
			y[t] -= 1;
		}
		/// 最終結果(sunspotspredictions.txtの表示)
		for(t=299 ; t<=315 ; t++){
			System.out.println(data[t][0] + "\t" + y[t]);
		}
		/// 比較用オリジナルデータの表示(sunspots1990_2015.txtの表示)
		for(t=290 ; t<=315 ; t++){
//			System.out.println(data[t][0] + "\t" + data[t][1]);
		}
		
	}
}