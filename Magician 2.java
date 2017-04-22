/**
 * Magician.java
 * Purpose: This program assigns the task of modeling the behavior of a character in a game under development. 
 * @author Sanjiv Karki
 * @version 1.0 04/26/2016
 */
public class Magician
{
   /**
    * Initialization of instance variables.
    */
   private String name;
   private String level;
   private String supplies;
   private double health;
   private int galleons;
   String [] runningLevel= { "apprentice","wizard","mage","sorcerer","shaman"};
   String [] differentSupplies= {"wand","staff","cauldron","telescope","broom"};
   final int[] priceForItems={300,75,100,150,200};
   
   /**
    * Sets a constructor
    * @param initialValues
    */
   public Magician(String initialValues)
   {
      String element[] = initialValues.split("#");
      name = element[0];
      name = name.trim();
      level = element[1];
      health=1000;
      galleons=200;
   }
   
      
   /**
    * This method causes the magician level to be promoted to the next level.
    * @return true if promoted otherwise false.
    */
   public boolean advanceLevel()
   {
      for(int i=0;i<=runningLevel.length-2;i++)
      {
         if(level.equals(runningLevel[i]))
         {
            level=runningLevel[i+1];
            galleons+=100;
            return true;
         }
      }
      return false;
   }
   
   /**
    * This method causes the magician level to be demoted to the next level.
    * @return true if demoted otherwise false.
    */

   public boolean downgradeLevel()
   {
      for(int i=runningLevel.length-1;i>0;i--)
         {
            if(level.equals(runningLevel[i]))  
            {
               level=runningLevel[i-1];
               if(galleons>100)
               {
                  galleons-=100;
                  return true;
               }
               else
               {
                  galleons=0;
                  return false;
               }
            }
         }
    return false;
   }
   /**
    * This method returns true if accessory char is valid or the character has enough galleons
    * @param type.
    */
   public boolean buyProp (char type)
   {
      if(type=='s' && galleons>= 300)
         {
            level+="#"+"staff";
            galleons-=300;
            return true;
         }

      else if(type=='c' && galleons>=75)
      {
         level+="#"+"cauldron";
         galleons-=75;
         return true;

      }
       else if(type=='b' && galleons>=100)
      {
         level+="#"+"broom";
         galleons-=100;
         return true;
      }
       else if(type=='t' && galleons>=150)
      {
         level+="#"+"telescope";
         galleons-=150;
         return true;

      }  
       else if(type=='w' && galleons>=200)
      {
         level+="#"+"wand";
         galleons-=200;
         return true;
      }
       return false;
   }
   
   /**
    * Sets a new magician character m in the game and sets the spell length of time.
    * @param m 
    * @param lenghtOfTime
    */
   public void spellBind (Magician m, int lengthOfTime)
   {
      int arrayOne=0;
      int arrayTwo=0;
      final double LOW_LEVEL=0.02;
      final double SAME_LEVEL=0.05;
      final double BONUS=10;
      
      for(int i=0;i<runningLevel.length;i++)
      {
         if(runningLevel[i].equals(m.level))
         {
         arrayTwo=i;
         }
         if(runningLevel[i].equals(this.level))
         {
         arrayOne=i;
         }
      }

      
      if(m.level.equals(this.level))
      {
         this.health+=m.health*SAME_LEVEL;
         m.health-=m.health*SAME_LEVEL;
         if(m.health>=BONUS*lengthOfTime)
         {
            m.health-=BONUS*lengthOfTime;
            this.health+=BONUS*lengthOfTime;
         }
         else
         {
            this.health+=m.health;
            m.health=0;
         }
      }
             
         
      else if(arrayOne>arrayTwo)
      {
         int t=0;
         while(t<lengthOfTime)
         {
            this.health+=SAME_LEVEL*m.health;
            m.health-=SAME_LEVEL*m.health;
            t++;
         }
      }
      
      else
      {
         this.health+=LOW_LEVEL*m.health;
         m.health-=LOW_LEVEL*m.health;
      }   
   }
     
   /**
    * This method returns true if the magician has the same name, level, health points and galleons
    * @return true otherwise false.
    */
   public boolean equals(Magician m)
   {
      if(name.equals(m.name) && level.equals(m.level) && (health==m.health) && (galleons==m.galleons))
      return true;
      return false;
   }   
   /**
    * This method returns value stored in name field.
    * @return name of the magician.
    */
   public String getName(){
      return name;
   }
   
   /**
    * This method returns value stored in level field.
    * @return level of the magician.
    */
   public String getLevel(){
      return level;
   }
   
   /**
    * This method returns value stored in health field.
    * @return health of magician.
    */
   public double getHealth(){
      return health;
   }
   
   /**
    * This method returns value stored in galleons field.
    * @return galleons.
    */
   public int getGalleons(){
      return galleons;
   }
   
   /** 
    * This method returns the string representation of the object.
    * @return String representation of the object in format form.
    */
   public String toString()
   {
      return ("Name: "+name+"\nLevel: "+level+"\nSupplies: "+supplies+"\nHealth: "+health+"\nGalleons: "+galleons);
   }
   
}     
