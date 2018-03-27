import {Component, OnInit, ViewChild} from "@angular/core";
import {Http} from "@angular/http";
import {Router} from "@angular/router";

import {Associate} from "../associate/associate";
import {NgModel, FormGroup} from "@angular/forms";



/**
 * description goes here...
 *
 * @author Devin Spivey
 * @since 6/28/2017
 */
@Component({
    selector: 'dashboard-component',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css'],
})

export class DashboardComponent implements OnInit {
    private currentAssociate: Associate;

    constructor(private http: Http,
                private router: Router) {
    }

    ngOnInit(): void {
        // initialize services and data
        this.http
            .get('api/dashboard')
            .toPromise()
            .then(response => {
                let data = response.json();

                if (data.currentAssociate) this.currentAssociate = data.currentAssociate as Associate;
            })
            .catch(error => {
                //alert("Error...");
             //   this.alertService.error(error);
            });
       
    }
}
