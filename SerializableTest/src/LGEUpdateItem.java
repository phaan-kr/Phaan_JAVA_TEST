import java.io.Serializable;

	class LGEUpdateItem implements Serializable { // innerclass로 사용하니깐 에러남...
		
		private static final long serialVersionUID = -9089239011976770033L;
		
		private String title;
		private String link;
		private String content;
		
		public LGEUpdateItem(String title, String link, String content)
		{
			this.title = title;
			this.link = link;
			this.content = content;
		}
		
		public String getTitle()
		{
			return title;
		}
		
		public String getLink()
		{
			return link;
		}
		
		public String getContent()
		{
			return content;
		}
	}