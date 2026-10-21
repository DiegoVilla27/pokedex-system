import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
  imports: [],
  standalone: true,
  selector: 'app-details',
  templateUrl: './details.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DetailsPage {}
