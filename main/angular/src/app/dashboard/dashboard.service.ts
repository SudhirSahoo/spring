import {Injectable}     from "@angular/core";
import {Headers, Http}  from "@angular/http";

import 'rxjs/add/operator/toPromise';


/**
 * Service that will handle interactions with the backend API service
 * for Dashboard entities.
 *
 * @author Devin Spivey
 * @since 6/28/2017
 */
@Injectable()
export class DashboardService {
    private serviceUrl = 'api/dashboard';
    private headers = new Headers({'Content-Type':'application/json'});
    
    
}
