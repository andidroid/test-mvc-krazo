package me.andidroid.testwar;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "test", schema = "public")
@EntityListeners(LoggingEntityListener.class)
public class Test
{
    
    @Id
    private long id;
    @NotNull
    private String text;
    
    public Test()
    {
    }
    
    public Test(long id, String text)
    {
        this.id = id;
        this.text = text;
    }
    
    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }
    
    /**
     * @return the text
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * @param text the text to set
     */
    public void setText(String text)
    {
        this.text = text;
    }
    
    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
