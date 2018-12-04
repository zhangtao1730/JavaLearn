his(srcPath, destDir, 1024);
	}
	
	private void init(){
		//总长度
		long len=this.src.length();
		//块数：多少块
		this.size=(int)Math.ceil(len*1.0/blockSize);
		//路径
		for(int i=0;i<size;i++){
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	/**
	 * 分割
	 * 1、计算每一块的起始位置和大小
	 * 2、分割
	 * @throws IOException 
	 */
	public void split() throws IOException{
		//总长度
		long len=src.length();
		//起始位置和实际大小
		int beginPos=0;
		int actualSize=(int)(blockSize>len?len:blockSize);
		for(int i=0;i<size;i++){
			beginPos=i*blockSize;
			if(i==size-1){//最后一块
				actualSize=(int)len;
			}else{
				actualSize=blockSize;
				len-=actualSize;
			}
			splitDetail(i,beginPos,actualSize);
		}
	}
	
	/**
	 * 指定第i块的起始位置和实际长度
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	private void splitDetail(int i ,int beginPos,int a