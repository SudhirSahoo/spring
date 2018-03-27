import {Component, OnInit, ViewChild} from "@angular/core";
import {Http} from "@angular/http";
import {Router} from "@angular/router";



/**
 * description goes here...
 *
 * @author Devin Spivey
 * @since 6/28/2017
 */
@Component({
    selector: 'home-component',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
})

export class HomeComponent implements OnInit {
	title = 'IQS Application';
  	greeting = {'id': 'vfc91343', 'content': 'Hello World'};

    ngOnInit(): void {
        console.log("Home Page");
    }
}
