package sample;

import com.sun.imageio.plugins.common.ImageUtil;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Date;
import java.util.Random;



public class Main extends Application implements EventHandler<MouseEvent> {

    Stage main;
    public Player p = new Player("123",1,1,1);
    public XiaoBin xb = new XiaoBin( "xiaobing",1,1,1 );
    Button startWar_one = new Button();
    Button startWar_Many = new Button();
    Button inv = new Button();

    ImageView player = new ImageView( new Image("images/stand.png") );
    ImageView xbPNG_one = new ImageView( new Image( "images/xb.png" ) );
    ImageView xbPNG_two = new ImageView( new Image( "images/xb.png" ) );
    ImageView xbPNG_three = new ImageView( new Image( "images/xb.png" ) );
    ImageView xbPNG_four = new ImageView( new Image( "images/xb.png" ) );
    ImageView cjbPNG = new ImageView( new Image( "images/cjb.png" ) );
    ImageView sw = new ImageView( new Image("images/sword.png") );

    @Override
    public void start(Stage primaryStage) throws Exception{

        main = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("红岩网校第 2 次作业");

        FirstStart( primaryStage );

        primaryStage.show();

        ScannPlayer(primaryStage);
    }

    private void upDateTitle(Stage primaryStage) {
        primaryStage.setTitle( "红岩网校第 2 次作业"+"          " + getPlayerSX());
    }

    private String getPlayerSX() {
        return ("玩家信息: " + p.getName() + "    攻击力:"+p.getDamage() + "    防御力:"+p.getDefence()+"    生命值:"+p.getHealth() );
    }

    private void ScannPlayer(Stage primaryStage) {

        Stage first = new Stage();
        first.setTitle("这是你第一次登入游戏");
        first.centerOnScreen();

        first.setMaxWidth(400);
        first.setMaxHeight(300);first.setX(800);first.setY(400);

        Pane pane = new HBox();
        pane.setPadding(new Insets(0,0,0,0));

        TextField idScan = new TextField();TextField helScan = new TextField();
        idScan.setPromptText("玩家ID");helScan.setPromptText("玩家生命值");
        idScan.setFocusTraversable(false);helScan.setFocusTraversable(false);
        helScan.setTranslateX(-95);
        helScan.setTranslateY(40);helScan.setMinWidth( helScan.getWidth()+100 );

        TextField damageScan = new TextField();
        damageScan.setPromptText( "玩家攻击力" );
        damageScan.setTranslateY(80);
        damageScan.setTranslateX(-195);
        damageScan.setFocusTraversable(false);

        TextField deScan = new TextField();
        deScan.setPromptText( "玩家防御力" );
        deScan.setFocusTraversable( false );
        deScan.setTranslateX(-285);
        deScan.setTranslateY(120);

        pane.getChildren().addAll( idScan , helScan , damageScan , deScan );
        Scene s = new Scene(pane,400,200);
        first.setScene(s);
        first.show();

        first.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {


                if ( idScan.getText().length() == 0 || helScan.getText().length() == 0
                || damageScan.getText().length() == 0|| deScan.getText().length() == 0){


                    System.out.println("未输入，视为默认值");

                }else {

                    p.setName(idScan.getText());
                    p.setHealth(Integer.parseInt(helScan.getText()));
                    p.setDamage(Integer.parseInt(damageScan.getText()));
                    p.setDefence(Integer.parseInt(deScan.getText()));

                    upDateTitle(primaryStage);


                }
                ScannXB(primaryStage);
            }
        });

    }

    private void ScannXB(Stage primaryStage) {

        Stage first = new Stage();
        first.setTitle("这是你第一次登入游戏");
        first.centerOnScreen();

        first.setMaxWidth(400);
        first.setMaxHeight(300);first.setX(800);first.setY(400);

        Pane pane = new HBox();
        pane.setPadding(new Insets(0,0,0,0));

        TextField helScan = new TextField();
        helScan.setPromptText("小兵生命值");
        helScan.setFocusTraversable(false)
        ;helScan.setMinWidth( helScan.getWidth()+100 );

        TextField damageScan = new TextField();
        damageScan.setPromptText( "小兵攻击力" );
        damageScan.setTranslateY(40);
        damageScan.setTranslateX(-125);
        damageScan.setFocusTraversable(false);

        TextField deScan = new TextField();
        deScan.setPromptText( "小兵防御力" );
        deScan.setFocusTraversable( false );
        deScan.setTranslateX(-250);
        deScan.setTranslateY(80);

        pane.getChildren().addAll(  helScan , damageScan , deScan );
        Scene s = new Scene(pane,400,200);
        first.setScene(s);
        first.show();

        first.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                if (!(  helScan.getText().length() == 0
                        || damageScan.getText().length() == 0|| deScan.getText().length() == 0)) {
                    xb.setHealth(Integer.parseInt(helScan.getText()));
                    xb.setDamage(Integer.parseInt(damageScan.getText()));
                    xb.setDefence(Integer.parseInt(deScan.getText()));
                }else
                    System.out.println("未输入，视为默认值");

            }
        });

    }

    private void FirstStart(Stage primaryStage) {

        primaryStage.getIcons().add( new Image( "images/icon.png" ) );  //icon;

        Pane pane = new HBox();
        pane.setPadding(new Insets(0,0,0,0));

        Scene scene2 = new Scene(pane,1050,750);
        //bg

        xbPNG_one.setTranslateX( 400 );xbPNG_one.setTranslateY(400 - 50);
        xbPNG_two.setTranslateX( 400-80 );xbPNG_two.setTranslateY(480 - 50);
        xbPNG_three.setTranslateX( 400-160 );xbPNG_three.setTranslateY(560 - 50);
        xbPNG_four.setTranslateX( 400-240 );xbPNG_four.setTranslateY(640 - 50);
        cjbPNG.setTranslateX( 0 );cjbPNG.setTranslateY( 460 );

        player.setTranslateX(200);player.setTranslateY(470); //初始化
        player.setViewport(new Rectangle2D(0, 0, 300, 300));
        pane.getChildren().addAll( player , xbPNG_one,xbPNG_two,xbPNG_three,xbPNG_four,cjbPNG);
        scene2.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();

            if (code.equals(KeyCode.LEFT)) { // 按下了左键

                if ( ( player.getTranslateX() == 210 || player.getTranslateX() == 680 )  && player.getTranslateY() <= 230 ){
                    return;
                }else {

                    for (int k = 0; k < 10; k++)
                        player.setTranslateX(player.getTranslateX() - 1);
                }
            } else if (code.equals(KeyCode.RIGHT) ) {//按下了右键
                if ( ( player.getTranslateX() == 140 || player.getTranslateX() == 610 )  && player.getTranslateY() <= 290 ){
                    return;}
                else {
                    for (int k = 0; k < 10; k++)
                        player.setTranslateX(player.getTranslateX() + 1);
                }
            } else if (code.equals(KeyCode.UP)) {//按下了上方向键

                if ( ( (player.getTranslateX() > 130 && player.getTranslateX() < 370 ) ||
                        player.getTranslateX() > 390 && player.getTranslateX() < 670) && player.getTranslateY() == 300 ){

                    return;
                }else {
                    for (int k = 0; k < 10; k++)
                        player.setTranslateY(player.getTranslateY() - 1);
                }
            } else if (code.equals(KeyCode.DOWN)) {//按下了下方向键

                if ( ( ( player.getTranslateX() >= 210 && player.getTranslateX() < 370 ) ||
                        ( player.getTranslateX() > 390 && player.getTranslateX() <= 610 )) && player.getTranslateY() == 220 ){
                    return;
                }else {

                    for (int k = 0; k < 10; k++)
                        player.setTranslateY(player.getTranslateY() + 1);
                }
            }
        });

        ImagePattern imagePattern = new ImagePattern(new Image("images/bg.png"), 0, 0, 1, 1, true);
        pane.setBackground( new Background(new BackgroundFill(imagePattern, CornerRadii.EMPTY, Insets.EMPTY)) );
        //bg setting

        primaryStage.setMaxHeight( 750 );primaryStage.setMinHeight( 750 );
        primaryStage.setMaxWidth( 1050 );primaryStage.setMinWidth( 1050 );//设置不可缩放

        startWar_one.setMinSize( 200,30 );startWar_Many.setMinSize(200 ,30 );

        startWar_one.setText( "点击对单个小兵发起挑战" );
        startWar_one.setTranslateX(80);startWar_one.setTranslateY(100);
        startWar_Many.setText( "点击对多个小兵发起挑战" );
        startWar_Many.setTranslateX( -120 );startWar_Many.setTranslateY( 140 );

        pane.getChildren().addAll( startWar_one,startWar_Many );
        startWar_one.setOnMouseClicked(this);
        startWar_Many.setOnMouseClicked(this);

        inv.setText("背包");
        inv.setTranslateY(100);inv.setTranslateX(-1000);
        inv.setMinSize( 80 ,30 );
        pane.getChildren().add( inv );inv.setOnMouseClicked(this);

        primaryStage.setScene( scene2 );

    }


    Text t = new Text();
    public void handle(MouseEvent event) {
        if ( event.getSource() == sw ){

            if ( sw.getTranslateX() != 340 && sw.getTranslateY() != 40 ) {

                sw.setTranslateX(420 - sw.getTranslateX());
                sw.setTranslateY(-90 + sw.getTranslateY());

                t.setText( t.getText().replace("\n(左键点击装备)","") );
                t.setTranslateX( t.getTranslateX() + 260 );
                t.setTranslateY( -90 + t.getTranslateY() );

                p.setS(p.getBag().getItems().get(0));

                Item i = p.getS();
                p.setDamage(p.getDamage() + i.damage_add);
                p.setHealth(p.getHealth() + i.hel_add);
                p.setDefence(p.getDefence() + i.de_add);

                p.getBag().getItems().remove(0);

                upDateTitle(main);
            }
            return;

        }

        if (event.getSource() == startWar_one ){

            XiaoBin xiaobin = new XiaoBin( "一个普通的小兵" , xb.health , xb.damage , xb.defence );
            Stage pvp = new Stage();
            Pane pane = new HBox();
            Text tt = new Text();
            pane.getChildren().add(tt);
            Scene s = new Scene(pane,300,200);
            pvp.setScene( s );
            pvp.show();
            pvp.getIcons().add( new Image( "images/icon.png" ) );  //icon;

            int rank = 0;// 0 == p, 1 == xb

            while ( p.situaion && xiaobin.situation){

                if ( p.getHealth() <= 0 ) {
                    tt.setText(tt.getText() + "\n" + "---------------------\n玩家死亡 战斗结束！" );

                    main.close();

                    break;
                }
                if ( xiaobin.getHealth() <= 0 ) {
                    tt.setText(tt.getText() + "\n" + "---------------------\n恭喜你获得胜利！" );
                    break;
                }


                if ( rank == 0 ){

                    int dam = (p.getDamage() - xiaobin.getDefence());

                    if ( dam <= 0 )
                        dam = 1;

                    xiaobin.setHealth( xiaobin.getHealth() - dam);

                    tt.setText( tt.getText() +"\n"+ "玩家对小兵造成伤害 " + dam );

                    rank = 1;

                    continue;
                }
                if ( rank == 1 ){

                    int dam = (xiaobin.getDamage() - p.getDefence());

                    if ( dam <= 0 )
                        dam = 1;

                    p.setHealth( p.getHealth() - dam );
                    tt.setText( tt.getText() +"\n"+ "小兵对玩家造成伤害 " + dam );

                    rank = 0;

                    continue;

                }



            }

        }

        if ( event.getSource() == startWar_Many ){


            XiaoBin[] xbs = {   new XiaoBin("一号小兵", xb.health , xb.damage , xb.defence ) ,
                                new XiaoBin("二号小兵", xb.health , xb.damage , xb.defence ),
                                new XiaoBin("测试小兵", xb.health , xb.damage , xb.defence )};
            ChaoJiBin cjb = new ChaoJiBin( "超级兵" , xb.health , xb.damage , xb.defence );

            Stage pvp = new Stage();
            pvp.getIcons().add( new Image( "images/icon.png" ) );  //icon;
            ScrollBar s1 = new ScrollBar();
            s1.setMax(500);
            s1.setOrientation(Orientation.VERTICAL);
            Pane pane = new HBox();
            Text tt = new Text();
            pane.getChildren().addAll(tt,s1);
            Scene s = new Scene(pane,300,900);
            pvp.setScene( s );
            pvp.setTitle( "战斗信息" );
            pvp.show();
            pvp.setX( main.getX() + main.getWidth() );
            pvp.setY( main.getY() - 100 );
            Date d = new Date();

            Random r = new Random( d.getTime() );//使随机种子改变
            int rank = 0;//0 == hero , 1 == xb;

            int line = 0;

            while ( true ){

                if ( xbs[0].health <= 0 && xbs[1].health <=0 && xbs[2].health <= 0 && cjb.health <=0 ) {

                    line+=2;

                    tt.setText( tt.getText() + "\n----------------\n游戏结束，恭喜你胜利了！");
                    break;
                }
                if ( p.getHealth() <= 0 ){
                    line+=2;
                    tt.setText( tt.getText() + "\n----------------\n游戏结束，你死了！" );
                    main.close();
                    break;
                }

                if ( rank == 0 ){

                    int k = r.nextInt(2);
                    if ( k == 0 ){

                        int dam = p.getDamage() - cjb.getDefence();
                        if ( dam <= 0 )
                            dam = 1;
                        cjb.setHealth( cjb.getHealth() - dam );
                        line++;
                        tt.setText( tt.getText() + "\n你对超级兵造成了 "+dam+ " 点伤害" );
                        rank = 1;
                        line++;
                        tt.setText( tt.getText() + "\n----------------");//分割线
                        continue;
                    }//damage cjb

                    if ( k == 1 ){

                        int ra = r.nextInt(3);
                        int dam = p.getDamage() - cjb.getDefence();
                        if ( dam <= 0 )
                            dam = 1;
                        xbs[ra].setHealth( xbs[ra].getHealth() - dam );
                        line+=2;
                        tt.setText( tt.getText() + "\n你对小兵 " + ra +" 号造成了 "+dam+ " 点伤害" );
                        rank = 1;
                        tt.setText( tt.getText() + "\n----------------" );//分割线
                        continue;
                    }//hero damage xb

                }//hero damage xb
                if ( rank == 1 ){

                    int cj_dam = cjb.damage - p.getDefence();
                    if ( cj_dam  <= 0)
                        cj_dam = 1;

                    if ( r.nextInt(100) >= cjb.rate ){
                        cj_dam*=2;
                        line++;
                        tt.setText( tt.getText() + "\n打出了致命一击！！！！" );
                    }//暴击
                    p.setHealth( p.getHealth() - cj_dam );
                    line++;
                    tt.setText( tt.getText() + "\n超级兵对你造成了 " + cj_dam +" 点伤害" );
                    for ( int i = 0 ; i < 3 ; i++ ){

                        int dam = xbs[i].getDamage() - p.getDefence();
                        if ( dam <= 0 )
                            dam = 1;
                        p.setHealth( p.getHealth() - dam );
                        line++;
                        tt.setText( tt.getText() + "\n小兵 " + i +" 号对你造成了 "+dam+ " 点伤害"  );

                    }
                    line++;
                    tt.setText( tt.getText() +  "\n----------------" );
                    rank = 0;
                    continue;

                }//xb damage hero


            }

            if ( line >= 46 )
                tt.setTranslateY( 20 * ( 45 - line ) );

        }

        if (event.getSource() == inv ){

            Stage inven = new Stage();
            inven.setTitle( p.getBag().title );
            Text te = new Text();

            Pane pane = new HBox();

            ImagePattern imagePattern = new ImagePattern(new Image("images/inv.png"), 0, 0, 1, 1, true);
            pane.setBackground( new Background(new BackgroundFill(imagePattern, CornerRadii.EMPTY, Insets.EMPTY)) );
            //bg setting

            pane.setPadding(new Insets(0,0,0,0));

            if ( p.getS() != null ){

                sw.setViewport(new Rectangle2D(0, 0, 300, 300));
                pane.getChildren().add(sw);
                sw.setTranslateY( 40 );
                sw.setTranslateX( 340 );
                sw.setOnMouseClicked(this);

                Item i = p.getS();

                te.setText( i.name  + "\n--------------" +
                        "\n攻击力 +"+i.damage_add + "\n生命值 +"+i.hel_add+"\n防御力 +"+i.de_add);;
                te.setTranslateY(100);
                te.setTranslateX( 30 );
                pane.getChildren().add( te );

            }

            int w = 80;int h = 130;

            for ( Item i : p.getBag().getItems() ){

                if ( i.getType() == ItemType.Sword ) {
                    sw.setViewport(new Rectangle2D(0, 0, 300, 300));
                    pane.getChildren().add(sw);
                    sw.setTranslateY( h );
                    sw.setTranslateX( w );


                    t.setText( i.name + "\n(左键点击装备)" + "\n--------------" +
                            "\n攻击力 +"+i.damage_add + "\n生命值 +"+i.hel_add+"\n防御力 +"+i.de_add);
                    t.setTranslateX( -220 );
                    t.setTranslateY( 200 );
                    pane.getChildren().add(t);


                    sw.setOnMouseClicked(this);
                }

            }

            Scene s = new Scene(pane,542,440);
            inven.setScene( s );

            inven.show();


        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
